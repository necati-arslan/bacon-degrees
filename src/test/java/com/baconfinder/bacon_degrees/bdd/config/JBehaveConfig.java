package com.baconfinder.bacon_degrees.bdd.config;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class JBehaveConfig {

    @Bean
    public Configuration jbehaveConfiguration() {
        return new org.jbehave.core.configuration.MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(Format.CONSOLE, Format.TXT, Format.HTML)
                        .withRelativeDirectory("jbehave-reports"));
    }
}
