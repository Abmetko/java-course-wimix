package com.javc.serialization.setNewValueInDeserializedObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class ReplaceJsonObject {

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Weather weather = objectMapper.readValue(ReplaceJsonObject.class.getResourceAsStream("/weather.json"), Weather.class);

        City city = objectMapper.readValue(ReplaceJsonObject.class.getResourceAsStream("/city.json"), City.class);

        weather.setCity(city);

        System.out.println(objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(weather));
    }
}