package com.baconfinder.bacon_degrees.bdd.steps.limit;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.jbehave.core.annotations.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Component
public class ActorRateLimitSteps {

    private final List<Response> responses = new ArrayList<>();



    @Given("the Actor API base is running")
    public void actorApiUp() {
        // Optionally ping /actuator/health if exposed
    }

    @When("I burst $count GET requests to \"$path\" within $seconds second")
    @Alias("I burst $count GET requests to \"$path\" within $seconds seconds")
    public void burst(int count, String path, int seconds) {
        long deadline = Instant.now().plusSeconds(seconds).toEpochMilli();
        for (int i = 0; i < count; i++) {
            Response r = RestAssured
                    .given()
                    .basePath(path)   // absolute path like /api/actors/nm0000001
                    .when()
                    .get()
                    .then()
                    .extract()
                    .response();
            responses.add(r);
            if (Instant.now().toEpochMilli() > deadline) break;
        }
    }

    @Then("the last actor response status should be $status")
    public void lastStatus(int status) {
        assertThat("No responses captured", responses, is(not(empty())));
        Response last = responses.get(responses.size() - 1);
        assertThat(last.statusCode(), is(status));
    }

    @Then("the last actor response should include header \"$headerName\"")
    public void hasHeader(String headerName) {
        Response last = responses.get(responses.size() - 1);
        assertThat(last.getHeader(headerName), notNullValue());
    }
}
