package com.javc.serialization.jacksonAnnotation.jsonIgnoreProperties;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonIgnoreProperties_Test {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Items1 items1 = objectMapper.readValue(new File("src/main/java/com/javc/serialization/jacksonAnnotation/jsonIgnoreProperties/items.json"), Items1.class);
    }
}
//поле помеченное этой аннотацией не будет десериализовано
@JsonIgnoreProperties(ignoreUnknown = true) //для всех неизвестных полей или конкретных @JsonIgnoreProperties({ "id" })

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "items"
})
class Items1 {

    @JsonProperty("id")
    private String id;

    @JsonProperty("items")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)//для случая, когда может быть вариант массива json объектов или объекта
    private List<Item2> items = null;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("items")
    public List<Item2> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item2> items) {
        this.items = items;
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name"
})
class Item2 {

    @JsonProperty("name")
    private String name;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
}