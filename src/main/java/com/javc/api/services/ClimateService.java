package com.javc.api.services;

import com.javc.dto.Weather;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ClimateService {

    private final static String X_RAPID_API_KEY = "df5e4a8bbamshaab7d290241c1ecp1cb031jsn1ded64b3bdfb";
    private final static String X_RAPID_API_HOST = "community-open-weather-map.p.rapidapi.com";

    public Weather getWeather(String cityName) {
        return given()
                .header("x-rapidapi-key", X_RAPID_API_KEY)
                .header("x-rapidapi-host", X_RAPID_API_HOST)
                .queryParam("q", cityName)
                .when()
                .get("https://community-open-weather-map.p.rapidapi.com/climate/month")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Weather.class);
    }
}