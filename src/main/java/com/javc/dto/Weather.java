package com.javc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cod",
        "city",
        "message",
        "days"
})
public class Weather {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("city")
    private City city;
    @JsonProperty("message")
    private Double message;
    @JsonProperty("list")
    private List<Days> days = null;

    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    @JsonProperty("message")
    public Double getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(Double message) {
        this.message = message;
    }

    @JsonProperty("list")
    public List<Days> getList() {
        return days;
    }

    @JsonProperty("list")
    public void setList(List<Days> days) {
        this.days = days;
    }
}