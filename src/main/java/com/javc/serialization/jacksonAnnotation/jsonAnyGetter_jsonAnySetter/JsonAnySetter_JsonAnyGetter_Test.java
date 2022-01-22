package com.javc.serialization.jacksonAnnotation.jsonAnyGetter_jsonAnySetter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class JsonAnySetter_JsonAnyGetter_Test {

    /*
    Для случая, если в json присутствуют поля, которые явно не определены в pojo классе

    @JsonIgnore
    [private Map<String, Object> additionalProperties + @JsonAnySetter] + optional @JsonAnyGetter


     */
    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Dog dog = objectMapper.readValue(new File("src/main/java/com/javc/serialization/jacksonAnnotation/jsonAnyGetter_jsonAnySetter/dog.json"), Dog.class);
        System.out.println(dog.getAge());
//        System.out.println(dog.getAdditionalProperties().get("additional_field"));
    }
}