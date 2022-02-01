package com.javc.serialization.setNewValueInDeserializedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cod",
        "city",
        "message",
        "list"
})
public class Weather {

    @JsonProperty("cod")
    public String cod;
    @JsonProperty("city")
    public City city;
    @JsonProperty("message")
    public Double message;
    @JsonProperty("list")
    public List<Day> list = null;

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }
}