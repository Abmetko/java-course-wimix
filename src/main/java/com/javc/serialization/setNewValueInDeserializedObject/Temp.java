package com.javc.serialization.setNewValueInDeserializedObject;

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
}