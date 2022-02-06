package com.javc.jdbc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonProperty("list")
    private List<Day> days;

    @JsonProperty("list")
    public List<Day> getDays() {
        return days;
    }
}