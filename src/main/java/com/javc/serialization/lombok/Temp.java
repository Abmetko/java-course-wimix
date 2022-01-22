package com.javc.serialization.lombok;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;


@Value
@Jacksonized
@Builder
@Getter
public class Temp {

    Double average;
    Double average_max;
    Double average_min;
    Double record_max;
    Double record_min;

    @JsonAnySetter
    @Singular("any")
    Map<String, Object> any;
}