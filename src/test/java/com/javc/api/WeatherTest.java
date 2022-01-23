package com.javc.api;

import com.javc.dto.Weather;
import org.junit.jupiter.api.*;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WeatherTest extends BaseTest {

    private final static String CITY = "Minsk";
    private Weather weather;

    @DisplayName("Number of days should be equal to 30")
    @Order(1)
    @Test
    public void numberOfDaysShouldBe30() {
        weather = climateService.getWeather(CITY);
        assertEquals(30, weather.getList().size());
    }

    @DisplayName("City name should be equal to \"Minsk\"")
    @Test
    public void checkCityName() {
        assumeTrue(weather != null);
        assertEquals(CITY, weather.getCity().getName());
    }

    @DisplayName("Country code name should be equal to \"BY\"")
    @Test
    public void checkCountryCode() {
        assumeTrue(weather != null);
        assertEquals("BY", weather.getCity().getCountry());
    }

    @DisplayName("The first day in list should be current day")
    @Test
    public void theFirstDayInListShouldBeCurrent() {
        assumeTrue(weather != null);
        assertTrue(isTheFirstDayEqualToCurrent(weather.getList().get(0).getDt()));
    }

    public boolean isTheFirstDayEqualToCurrent(int timestamp) {
        LocalDate expectedDate = new Timestamp(timestamp * 1000L)//modify from epoch timestamp to timestamp in milliseconds
                .toLocalDateTime()
                .toLocalDate();
        LocalDate actualDate = LocalDate.now();
        return expectedDate.equals(actualDate);
    }
}