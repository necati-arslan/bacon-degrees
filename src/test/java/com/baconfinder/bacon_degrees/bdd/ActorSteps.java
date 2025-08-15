package com.baconfinder.bacon_degrees.bdd;

import io.restassured.RestAssured;
import org.jbehave.core.annotations.*;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


@Component
public class ActorSteps {

    @Given("the API base is running")
    public void apiBase() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @When("I request actor by nconst '$nconst'")
    public void requestActor(String nconst) {
        RestAssured.requestSpecification = given()
                .basePath("/api/actors")
                .pathParam("nconst", nconst);
    }

    @Then("the response should contain Kevin Bacon details")
    public void verifyKevinBacon() {
        given()
                .spec(RestAssured.requestSpecification)
                .when()
                .get("/{nconst}")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"))
                .body("nconst", equalTo("nm0000001"))
                .body("primaryName", equalTo("Kevin Bacon"))
                .body("birthYear", equalTo(1958))
                .body("deathYear", nullValue())
                .body("primaryProfession", containsString("actor"))
                .body("knownForTitles", anyOf(
                        equalTo("tt0000001,tt0000005"),
                        // DB'de listeyi ayrı kaydetsen de temel doğrulamayı sağlayalım:
                        containsString("tt0000001")
                ));
    }




    @Then("the response should be empty result")
    public void verifyEmptyResult() {
        String body =
                given()
                        .spec(RestAssured.requestSpecification)
                        .when()
                        .get("/{nconst}")
                        .then()
                        .statusCode(200)
                        .extract()
                        .asString();


        assertThat(body == null ? "" : body.trim(),
                anyOf(equalTo(""), equalTo("null"), equalTo("{}"), equalTo("[]")));
    }
}
