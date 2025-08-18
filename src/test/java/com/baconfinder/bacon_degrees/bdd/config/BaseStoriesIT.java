package com.baconfinder.bacon_degrees.bdd.config;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // keep 8080
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public abstract class BaseStoriesIT {

    @Autowired ApplicationContext applicationContext;
    @Autowired org.jbehave.core.configuration.Configuration jbehaveConfiguration;

    /** Override to restrict which stories run (by folder pattern). */
    protected List<String> storyPatterns() {
        // Support both flat "stories/*.story" (current) and nested "stories/**/*.story" (future)
        return List.of("**/stories/*.story", "**/stories/**/*.story");
    }

    /** Override to filter by JBehave meta tags, e.g., +smoke -wip. */
    protected List<String> metaFilters() {
        return List.of();
    }

    @Test
    void runStories() {
        Embedder embedder = new Embedder();
        embedder.useConfiguration(jbehaveConfiguration);
        embedder.useStepsFactory(new SpringStepsFactory(jbehaveConfiguration, applicationContext));
        if (!metaFilters().isEmpty()) embedder.useMetaFilters(metaFilters());

        List<String> storyPaths = new StoryFinder().findPaths(
                codeLocationFromClass(this.getClass()),
                storyPatterns(),
                List.of()
        );
        embedder.runStoriesAsPaths(storyPaths);
    }
}
