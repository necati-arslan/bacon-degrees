package com.baconfinder.bacon_degrees.bdd.steps.common;

import io.restassured.RestAssured;
import org.jbehave.core.annotations.BeforeScenario;
import org.springframework.stereotype.Component;

@Component
public class RestAssuredHooks {
    @BeforeScenario
    public void reset() {
        RestAssured.reset();
    }
}
