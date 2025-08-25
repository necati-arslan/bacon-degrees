package com.baconfinder.bacon_degrees.bdd.runners;

import com.baconfinder.bacon_degrees.bdd.config.BaseStoriesIT;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)

public class AllStoriesIT extends BaseStoriesIT {
    // uses defaults: runs both flat and nested stories

    // in each regular runner
    @Override
    protected List<String> metaFilters() {
        return List.of("-rateLimit");
    }
}
