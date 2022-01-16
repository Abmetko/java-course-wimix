package com.javc.serialization.dto_pojo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
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
        List<User> users = objectMapper.readValue(file, new TypeReference<List<User>>() {
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


        //Не записывать результат в файл, а вернуть строку в формате json
        String myJsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(users2);

//        System.out.println(myJsonString);

        //Сериализовать в строку объект HashMap
        /*
         * Serialization converts a Java object into a stream of bytes,
         * which can be persisted or shared as needed.
         * Java Maps are collections that map a key Object to a value Object,
         * and are often the least intuitive objects to serialize.
         */
        Map<String, Object> user1 = new LinkedHashMap<>();
        user1.put("name", "Alex");
        user1.put("address", "MSQ");
        user1.put("age", 50);

        Map<String, Object> user2 = new LinkedHashMap<>();
        user2.put("name", "Tom");
        user2.put("address", "NZD");
        user2.put("age", 35);

        Map<String, Object> usersMap = new HashMap<>();

        usersMap.put("users", new Map[]{user1, user2});

        String fromMapToString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(usersMap);

//        System.out.println(fromMapToString);


        //Десериализация из строки в формате json в объект HshMap
        TypeReference<HashMap<String, Object>> typeRef
                = new TypeReference<HashMap<String, Object>>() {
        };
        Map<String, Object> mapFromString = objectMapper.readValue(fromMapToString, typeRef);
//        System.out.println(mapFromString.toString());
    }
}