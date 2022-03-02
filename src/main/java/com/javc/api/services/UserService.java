package com.javc.api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javc.dto.gorest.User;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

import static com.javc.properties.PropertyProvider.getProperty;
import static com.javc.secure_random.GenerateRandomEmail.generateRandomEmail;
import static io.restassured.RestAssured.given;

public class UserService extends BaseRestService {

    private final RequestSpecification requestSpecification;

    public UserService() {
        requestSpecification = given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(getProperty("go.rest.token"));
        requestSpecification.baseUri("https://gorest.co.in/public");
        requestSpecification.basePath("/v2/users");
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.createUser_3();
    }

    //вариант с хардкодом в body
    public void createUser_1() {
        given()
                .spec(requestSpecification)
                .when()
                .body("{\"name\":\"Andrey\", \"gender\":\"male\", \"email\":\"" + generateRandomEmail() + "\", \"status\":\"active\"}")
                .post()
                .then()
                .statusCode(201);
    }

    //вариант с формированием объекта body с помощью Map
    public void createUser_2() {
        Map<String, Object> body = new HashMap<>();
        body.put("name", "Andrey");
        body.put("gender", "male");
        body.put("email", generateRandomEmail());
        body.put("status", "active");

        given()
                .spec(requestSpecification)
                .when()
                .body(body)
                .post()
                .then()
                .statusCode(201);
    }

    //вариант с формированием объекта body с помощью POJO
    @SneakyThrows
    public void createUser_3() {
        User body = new ObjectMapper().readValue(UserService.class.getResourceAsStream("/user.json"), User.class);
        body.setName("Andrey");
        body.setGender("male");
        body.setEmail(generateRandomEmail());
        body.setStatus("active");

        given()
                .spec(requestSpecification)
                .when()
                .body(body)
                .post()
                .then()
                .statusCode(201);
    }
}