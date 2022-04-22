package com.javc.serialization.jacksonAnnotation.jsonAnySetter;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class JsonAnySetterTest {

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "val1");
        map.put("key2", "val2");
        Folders folders = new Folders("Nick", map);

        System.out.println(objectMapper.writeValueAsString(folders)); //{"name":"Nick","key1":"val1","key2":"val2"}

        //without @JsonAnyGetter: {"name":"Nick","properties":{"key1":"val1","key2":"val2"}}
    }
}

class Folders {

    private final Map<String, String> properties;
    public String name;

    public Folders(String name, Map<String, String> properties) {
        this.name = name;
        this.properties = properties;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
