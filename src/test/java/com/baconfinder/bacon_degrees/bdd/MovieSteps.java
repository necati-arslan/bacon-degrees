package com.baconfinder.bacon_degrees.bdd;

import io.restassured.RestAssured;
import org.jbehave.core.annotations.*;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class MovieSteps {

    @BeforeScenario
    public void resetRestAssured() {
        // Prevent path-param/spec leakage from other step classes/scenarios
        RestAssured.reset();
    }

    @Given("the Movie API base is running")
    public void movieApiBase() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    } // Türkçe: Film API’si için temel adresi/portu ayarlıyoruz.

    @When("I request movie by tconst '$tconst'")
    public void requestMovie(String tconst) {
        RestAssured.requestSpecification = given()
                .basePath("/api/movies")
                .pathParam("tconst", tconst);
    }

    @Then("the response should contain Film A details")
    public void verifyFilmA() {
        given()
                .spec(RestAssured.requestSpecification)
                .when()
                .get("/{tconst}")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"))
                .body("tconst", equalTo("tt0000001"))
                .body("titleType", equalTo("movie"))
                .body("primaryTitle", equalTo("Film A"))
                .body("originalTitle", equalTo("Film A"))
                .body("startYear", equalTo(1990))
                .body("endYear", nullValue())
                .body("runtimeMinutes", equalTo(120))
                .body("genres", equalTo("Drama"))
                .body("adult", equalTo(false));
    }

    @Then("the movie response should be empty result")
    public void verifyEmptyMovieResult() {
        String body =
                given()
                        .spec(RestAssured.requestSpecification)
                        .when()
                        .get("/{tconst}")
                        .then()
                        .statusCode(200) // change to 404 if your API returns 404 for not found
                        .extract()
                        .asString();

        assertThat(body == null ? "" : body.trim(),
                anyOf(equalTo(""), equalTo("null"), equalTo("{}"), equalTo("[]")));
    }
}
