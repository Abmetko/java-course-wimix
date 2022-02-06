package com.javc.jdbc.dto;

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

    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    @Override
    public String toString() {
        return "Day{" +
                "dt=" + dt +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", temp=" + temp +
                ", windSpeed=" + windSpeed +
                '}';
    }
}