package com.baconfinder.bacon_degrees.bdd.steps.actor;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Component
public class ActorQuerySteps {



    private Response response;

    @BeforeScenario
    public void before() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    @Given("the API base is running")
    public void apiBase() {
        // Optionally ping a health endpoint or just rely on SpringBootTest. (İsterseniz bir sağlık uç noktasını ping’leyin veya SpringBootTest’e güvenin.)
    }

    @When("I request actor by nconst '$nconst'")
    public void requestActor(String nconst) {
        this.response = given()
                .basePath("/api/actors")
                .pathParam("nconst", nconst)
                .when()
                .get("/{nconst}");
    }

    @Then("the response status should be $status")
    public void theStatusShouldBe(int status) {
        response.then().statusCode(status);
    }

    @Then("the response content type should be JSON")
    public void contentTypeJson() {
        response.then().contentType(ContentType.JSON);
    }

    @Then("the actor payload should have nconst '$nconst'")
    public void payloadHasNconst(String nconst) {
        response.then().body("nconst", equalTo(nconst));
    }

    @Then("the actor payload should have primaryName '$name'")
    public void payloadHasName(String name) {
        response.then().body("primaryName", equalTo(name));
    }

    @Then("the actor payload should have birthYear $birth")
    public void payloadHasBirth(int birth) {
        response.then().body("birthYear", equalTo(birth));
    }

    @Then("the actor payload should have deathYear $death")
    public void payloadHasDeath(String death) {
        if ("null".equalsIgnoreCase(death)) {
            response.then().body("deathYear", anyOf(nullValue(), equalTo(null)));
        } else {
            response.then().body("deathYear", equalTo(Integer.valueOf(death)));
        }
    }

    @Then("the actor payload should include profession '$profession'")
    public void payloadIncludesProfession(String profession) {
        // supports CSV or array forms (CSV veya dizi biçimlerini destekler)
        String professions = response.then().extract().path("primaryProfession").toString();
        assertThat(professions, containsString(profession));
    }

    @Then("the actor payload should include knownFor '$titleId'")
    public void payloadIncludesKnownFor(String titleId) {
        String knownFor = response.then().extract().path("knownForTitles").toString();
        assertThat(knownFor, containsString(titleId));
    }


}
