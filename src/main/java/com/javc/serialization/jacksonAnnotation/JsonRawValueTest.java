package com.javc.serialization.jacksonAnnotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class JsonRawValueTest {

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Folder folder = new Folder(30, "{\"name\":\"Nick\",\"lastName\":\"Black\"}");

        System.out.println(objectMapper.writeValueAsString(folder));
        //{"age":30,"property":{"name":"Nick","lastName":"Black"}}
    }
}

class Folder {
    @JsonProperty("age")
    public int age;
    @JsonRawValue
    public String property;

    public Folder(int age, String property) {
        this.age = age;
        this.property = property;
    }
}