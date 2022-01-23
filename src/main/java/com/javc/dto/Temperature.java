package com.javc.dto;

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
class Temperature {

    @JsonProperty("average")
    private Double average;
    @JsonProperty("average_max")
    private Double averageMax;
    @JsonProperty("average_min")
    private Double averageMin;
    @JsonProperty("record_max")
    private Double recordMax;
    @JsonProperty("record_min")
    private Double recordMin;

    @JsonProperty("average")
    public Double getAverage() {
        return average;
    }

    @JsonProperty("average")
    public void setAverage(Double average) {
        this.average = average;
    }

    @JsonProperty("average_max")
    public Double getAverageMax() {
        return averageMax;
    }

    @JsonProperty("average_max")
    public void setAverageMax(Double averageMax) {
        this.averageMax = averageMax;
    }

    @JsonProperty("average_min")
    public Double getAverageMin() {
        return averageMin;
    }

    @JsonProperty("average_min")
    public void setAverageMin(Double averageMin) {
        this.averageMin = averageMin;
    }

    @JsonProperty("record_max")
    public Double getRecordMax() {
        return recordMax;
    }

    @JsonProperty("record_max")
    public void setRecordMax(Double recordMax) {
        this.recordMax = recordMax;
    }

    @JsonProperty("record_min")
    public Double getRecordMin() {
        return recordMin;
    }

    @JsonProperty("record_min")
    public void setRecordMin(Double recordMin) {
        this.recordMin = recordMin;
    }
}
