package com.baconfinder.bacon_degrees.bdd;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class ApiStoriesIT {
    
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    org.jbehave.core.configuration.Configuration jbehaveConfiguration;

    @Test
    void runStories() {
        Embedder embedder = new Embedder();
        embedder.useConfiguration(jbehaveConfiguration);

        InjectableStepsFactory stepsFactory =
                new SpringStepsFactory(jbehaveConfiguration, applicationContext);
        embedder.useStepsFactory(stepsFactory);

        List<String> storyPaths = new StoryFinder().findPaths(
                codeLocationFromClass(this.getClass()),
                asList("**/stories/*.story"),
                asList(""));

        embedder.runStoriesAsPaths(storyPaths);
    }
}
