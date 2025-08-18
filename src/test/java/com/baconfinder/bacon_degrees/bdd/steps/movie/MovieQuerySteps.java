package com.baconfinder.bacon_degrees.bdd.steps.movie;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.jbehave.core.annotations.*;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Component
public class MovieQuerySteps {

    private Response response;

    @BeforeScenario
    public void before() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Given("the Movie API base is running")
    public void movieApiBase() {
        // Optionally ping health endpoint or rely on SpringBootTest wiring
    }

    @When("I request movie by tconst '$tconst'")
    public void requestMovie(String tconst) {
        this.response = given()
                .basePath("/api/movies")
                .pathParam("tconst", tconst)
                .when()
                .get("/{tconst}");
    }

    // ---- Reusable THEN steps (parallel to your ActorQuerySteps) ----

    @Then("the movie response status should be $status")
    public void movieStatusShouldBe(int status) {
        response.then().statusCode(status);
    }

    @Then("the movie response content type should be JSON")
    public void movieContentTypeJson() {
        response.then().contentType(ContentType.JSON);
    }

    @Then("the movie payload should have tconst '$tconst'")
    public void payloadHasTconst(String tconst) {
        response.then().body("tconst", equalTo(tconst));
    }

    @Then("the movie payload should have primaryTitle '$title'")
    public void payloadHasPrimaryTitle(String title) {
        response.then().body("primaryTitle", equalTo(title));
    }

    @Then("the movie payload should have startYear $year")
    public void payloadHasStartYear(int year) {
        response.then().body("startYear", equalTo(year));
    }

    @Then("the movie payload should have endYear $year")
    public void payloadHasEndYear(String year) {
        if ("null".equalsIgnoreCase(year)) {
            response.then().body("endYear", anyOf(nullValue(), equalTo(null)));
        } else {
            response.then().body("endYear", equalTo(Integer.valueOf(year)));
        }
    }



    @Then("the movie error payload code should be '$code'")
    public void errorCode(String code) {
        response.then()
                .contentType(ContentType.JSON)
                .body("code", equalTo(code));
    }


    @Then("the movie response should be empty result")
    public void verifyEmptyResult() {

        String body = response == null ? "" : String.valueOf(response.asString()).trim();

        assertThat(body, anyOf(
                equalTo(""),
                equalTo("null"),
                equalTo("{}"),
                equalTo("[]"),
                containsString("\"items\":[]"),
                containsString("\"data\":null")
        ));
    }




}
