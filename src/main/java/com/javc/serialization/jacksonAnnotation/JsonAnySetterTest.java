package com.javc.serialization.jacksonAnnotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class JsonAnySetterTest {

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Dog dog = objectMapper.readValue(new File("src/main/java/com/javc/serialization/jacksonAnnotation/dog.json"), Dog.class);
        System.out.println(dog.getAdditionalProperties().get("additional_field"));
    }
}