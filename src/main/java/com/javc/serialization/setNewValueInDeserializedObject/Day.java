package com.javc.serialization.setNewValueInDeserializedObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dt",
        "humidity",
        "pressure",
        "temp",
        "wind_speed"
})
public class Day {

    @JsonProperty("dt")
    public Integer dt;
    @JsonProperty("humidity")
    public Double humidity;
    @JsonProperty("pressure")
    public Double pressure;
    @JsonProperty("temp")
    public Temp temp;
    @JsonProperty("wind_speed")
    public Double windSpeed;
}