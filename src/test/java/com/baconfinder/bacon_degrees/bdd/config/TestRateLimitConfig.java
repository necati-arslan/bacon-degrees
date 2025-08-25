package com.baconfinder.bacon_degrees.bdd.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@Profile("rl") // only active in the 'test' profile
@EnableConfigurationProperties(TestRateLimitConfig.RateLimitProps.class)
public class TestRateLimitConfig {

    @Bean
    @ConditionalOnProperty(name = "rate.limit.enabled", havingValue = "true")
    public OncePerRequestFilter testRateLimitFilter(RateLimitProps props) {
        return new SimpleFixedWindowRateLimiter(props);
    }

    @ConfigurationProperties(prefix = "rate.limit")
    public static class RateLimitProps {
        private boolean enabled;
        private int windowSeconds = 1;            // maps to rate.limit.window-seconds
        private int maxRequests = 2;              // maps to rate.limit.max-requests
        private int responseStatus = 429;         // maps to rate.limit.response-status
        private int retryAfterSeconds = 1;        // maps to rate.limit.retry-after-seconds

        public boolean isEnabled() { return enabled; }
        public void setEnabled(boolean enabled) { this.enabled = enabled; }
        public int getWindowSeconds() { return windowSeconds; }
        public void setWindowSeconds(int windowSeconds) { this.windowSeconds = windowSeconds; }
        public int getMaxRequests() { return maxRequests; }
        public void setMaxRequests(int maxRequests) { this.maxRequests = maxRequests; }
        public int getResponseStatus() { return responseStatus; }
        public void setResponseStatus(int responseStatus) { this.responseStatus = responseStatus; }
        public int getRetryAfterSeconds() { return retryAfterSeconds; }
        public void setRetryAfterSeconds(int retryAfterSeconds) { this.retryAfterSeconds = retryAfterSeconds; }
    }

    /** Limits only GET /api/actors/** with a simple fixed 1s window counter (sufficient for IT). */
    static class SimpleFixedWindowRateLimiter extends OncePerRequestFilter {
        private final RateLimitProps props;

        private volatile long windowStartMs = Instant.now().toEpochMilli();
        private final AtomicInteger counter = new AtomicInteger(0);

        SimpleFixedWindowRateLimiter(RateLimitProps props) {
            this.props = props;
        }

        @Override
        protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
                throws ServletException, IOException {

            String method = req.getMethod();
            String path = req.getRequestURI();

            // Hard scope: only GET /api/actors/**
            boolean targeted = "GET".equalsIgnoreCase(method) && path.startsWith("/api/actors/");
            if (!targeted) {
                chain.doFilter(req, res);
                return;
            }

            rotateWindowIfNeeded();

            int current = counter.incrementAndGet();
            if (current > props.getMaxRequests()) {
                res.setStatus(props.getResponseStatus());
                res.setHeader("Retry-After", String.valueOf(props.getRetryAfterSeconds()));
                res.setContentType("application/json");
                res.getWriter().write("{\"error\":\"rate_limited\",\"path\":\"" + path + "\"}");
                return;
            }

            chain.doFilter(req, res);
        }

        private void rotateWindowIfNeeded() {
            long now = Instant.now().toEpochMilli();
            long windowMs = props.getWindowSeconds() * 1000L;
            if (now - windowStartMs >= windowMs) {
                counter.set(0);
                windowStartMs = now;
            }
        }
    }
}
