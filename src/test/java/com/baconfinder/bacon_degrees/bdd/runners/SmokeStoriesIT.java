package com.baconfinder.bacon_degrees.bdd.runners;

import com.baconfinder.bacon_degrees.bdd.config.BaseStoriesIT;

import java.util.List;

public class SmokeStoriesIT extends BaseStoriesIT {
    @Override
    protected List<String> metaFilters() {
        return List.of("+smoke", "-wip");
    }
}
