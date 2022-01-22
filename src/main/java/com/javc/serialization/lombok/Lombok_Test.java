package com.javc.serialization.lombok;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class Lombok_Test {

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        WeatherWrapper weather = objectMapper
                .readValue(new File("src/main/java/com/javc/serialization/lombok/weather.json"),
                        WeatherWrapper.class);

        System.out.println(weather.getDays()
                .get(0)
                .getTemp()
                .getAverage_max());

        weather.getDays()
                .get(0)
                .setPressure(15000.0);

        System.out.println(weather.getDays()
                .get(0)
                .getPressure());

        objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValue(new File("src/main/java/com/javc/serialization/lombok/weather2.json"), weather);
    }
}