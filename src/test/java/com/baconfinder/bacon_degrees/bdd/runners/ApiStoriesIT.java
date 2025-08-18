package com.baconfinder.bacon_degrees.bdd.runners;

import com.baconfinder.bacon_degrees.bdd.config.BaseStoriesIT;

import java.util.List;

public class ApiStoriesIT extends BaseStoriesIT {
    @Override
    protected List<String> storyPatterns() {
        // future-proof: only API stories under /stories/api/**
        return List.of("**/stories/api/**/*.story");
    }
}
