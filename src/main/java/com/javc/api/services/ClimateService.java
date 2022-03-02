package com.javc.api.services;

import com.javc.dto.Weather;
import io.restassured.http.ContentType;

import static com.javc.properties.PropertyProvider.getProperty;
import static io.restassured.RestAssured.given;

public class ClimateService extends BaseRestService {

    private final static String X_RAPID_API_KEY = getProperty("x.rapid.api.key");
    private final static String X_RAPID_API_HOST = getProperty("x.rapid.api.host");

    public Weather getWeather() {
        return given()
                .header("x-rapidapi-key", X_RAPID_API_KEY)
                .header("x-rapidapi-host", X_RAPID_API_HOST)
                .queryParam("q", "Minsk")
                .when()
                .get("https://community-open-weather-map.p.rapidapi.com/climate/month")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Weather.class);
    }
}