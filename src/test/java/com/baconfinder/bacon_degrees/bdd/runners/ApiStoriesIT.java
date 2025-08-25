package com.baconfinder.bacon_degrees.bdd.runners;

import com.baconfinder.bacon_degrees.bdd.config.BaseStoriesIT;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@org.junit.jupiter.api.Disabled
public class ApiStoriesIT extends BaseStoriesIT {
    @Override
    protected List<String> storyPatterns() {
        // future-proof: only API stories under /stories/api/**
        return List.of("**/stories/api/**/*.story");
    }

    // in each regular runner
    @Override
    protected List<String> metaFilters() {
        return List.of("-rateLimit");
    }

}
