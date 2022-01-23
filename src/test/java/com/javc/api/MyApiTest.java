package com.javc.api;

import com.javc.api.services.ClimateService;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyApiTest {

    private final static String CITY = "Minsk";

    static {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    private final ClimateService climateService = new ClimateService();

    @DisplayName("Number of days should be equal to 30")
    @Test
    public void numberOfDaysShouldBe30() {
        assertEquals(30, climateService.getWeather(CITY).getList().size());
    }

    @DisplayName("City name should be equal to \"Minsk\"")
    @Test
    public void checkCityName() {
        assertEquals(CITY, climateService.getWeather(CITY).getCity().getName());
    }
}