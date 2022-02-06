package com.javc.jdbc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "average",
        "average_max",
        "average_min",
        "record_max",
        "record_min"
})
public class Temp {

    @JsonProperty("average")
    public Double average;
    @JsonProperty("average_max")
    public Double averageMax;
    @JsonProperty("average_min")
    public Double averageMin;
    @JsonProperty("record_max")
    public Double recordMax;
    @JsonProperty("record_min")
    public Double recordMin;

    @Override
    public String toString() {
        return "Temp{" +
                "average=" + average +
                ", averageMax=" + averageMax +
                ", averageMin=" + averageMin +
                ", recordMax=" + recordMax +
                ", recordMin=" + recordMin +
                '}';
    }
}