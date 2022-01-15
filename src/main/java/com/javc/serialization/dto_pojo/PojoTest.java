package com.javc.serialization.dto_pojo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class PojoTest {

    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("src/main/java/com/javc/serialization/dto_pojo/users.json");
        ObjectMapper objectMapper = new ObjectMapper();
/*
[
  {
    "name": "John",
    "address": "DC",
    "age": 15
  },
  {
    "name": "Tom",
    "address": "LA",
    "age": 18
  }
]
*/
        List<User> users = objectMapper.readValue(file, new TypeReference<>() {
        });
        System.out.println(users
                .get(0)
                .getName());

/*
{
  "users": [
    {
      "name": "John",
      "address": "DC",
      "age": 15
    },
    {
      "name": "Tom",
      "address": "LA",
      "age": 18
    }
  ]
}
*/
        file = new File("src/main/java/com/javc/serialization/dto_pojo/users2.json");
        Users users2 = objectMapper.readValue(file, Users.class);
        System.out.println(users2
                .getUsers()
                .get(0)
                .getName());

        User andrey = users2.getUsers().get(0);
        andrey.setName("Andrey");
        andrey.setAddress("Minsk");

        objectMapper.writeValue(new File("src/main/java/com/javc/serialization/dto_pojo/users3.json"), users2);
    }
}