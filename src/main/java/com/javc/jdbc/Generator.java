package com.javc.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.IOException;

public class Generator {

    @SneakyThrows
    public static <T> T parse(String body, Class<T> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(body, cls);
    }

    public static void main(String[] args) throws IOException {

    }
}