package com.javc.serialization.setNewValueInDeserializedObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class SetNewObjectTest {

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather = objectMapper.readValue(new File("src/main/java/com/javc/serialization/setNewValueInDeserializedObject/weather.json"),
                Weather.class);

        City city = objectMapper.readValue(new File("src/main/java/com/javc/serialization/setNewValueInDeserializedObject/city.json"), City.class);

        weather.setCity(city);

        System.out.println(
                objectMapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(weather)
        );
    }
}