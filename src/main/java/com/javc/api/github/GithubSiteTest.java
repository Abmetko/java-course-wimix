package com.javc.api.github;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GithubSiteTest {

    private static final RequestSpecification requestSpecification;

    static {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        requestSpecification = given()
                .cookies(SiteCookie.defaultCookies());
        requestSpecification.baseUri("https://github.com");
    }

    public static void profile() {
        given()
                .spec(requestSpecification)
                .basePath("/Abmetko")
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.HTML);
    }

    public static void repositories() {
        given()
                .spec(requestSpecification)
                .basePath("/Abmetko")
                .queryParam("tab", "repositories")
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.HTML);
    }

    public static void issues() {
        given()
                .spec(requestSpecification)
                .basePath("/issues")
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.HTML);
    }

    public static void main(String[] args) {
        issues();
    }
}