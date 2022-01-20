package com.javc.serialization.jacksonAnnotation.jsonFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonFormat_Test {

/*
{
  "id": "23233",
  "items": [
    {
      "name": "item 1"
    },
    {
      "name": "item 2"
    }
  ]
}

{
  "id": "23233",
  "items": {
      "name": "item"
    }
}
 */

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Items items = objectMapper.readValue(new File("src/main/java/com/javc/serialization/jacksonAnnotation/jsonFormat/items_long.json"), Items.class);
        System.out.println(items.getItems());

        items = objectMapper.readValue(new File("src/main/java/com/javc/serialization/jacksonAnnotation/jsonFormat/items_short.json"), Items.class);
        System.out.println(items.getItems());
    }
}
