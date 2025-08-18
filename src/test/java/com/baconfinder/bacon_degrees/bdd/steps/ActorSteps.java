package com.baconfinder.bacon_degrees.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.core.env.Environment;

import static org.hamcrest.Matchers.*;

public class ActorSteps {

    private final Environment env;
    private Response response;

    public ActorSteps(Environment env) { this.env = env; }

    @Given("the API base is running")
    public void the_api_base_is_running() {
        String port = env.getProperty("local.server.port");
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = Integer.parseInt(port);
    }

    @When("I request actor by nconst {string}")
    public void i_request_actor_by_nconst(String nconst) {
        response = RestAssured.given().accept("application/json")
                .when().get("/api/actors/{id}", nconst);
    }

    @Then("the response should contain Kevin Bacon details")
    public void the_response_should_contain_kevin_bacon_details() {
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("nconst", equalTo("nm0000001"))
                .body("primaryName", equalTo("Kevin Bacon"))
                .body("birthYear", equalTo(1958))
                .body("deathYear", nullValue())
                .body("primaryProfession", equalTo("actor"))
                .body("knownForTitles", equalTo("tt0000001,tt0000005"));
    }
}
