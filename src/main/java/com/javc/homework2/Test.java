package com.javc.homework2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> passports = objectMapper
                .readValue(new File("src/main/resources/json/file1.json"), Users.class)
                .getUsers()
                .stream()
                .map(user -> user.getPassport().replaceAll("[^\\d]", ""))
                .collect(Collectors.toList());

        System.out.println(passports);
    }
}