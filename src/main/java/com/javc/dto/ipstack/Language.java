package com.javc.dto.ipstack;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "code",
        "name",
        "native"
})
public class Language {

    @JsonProperty("code")
    public String code;
    @JsonProperty("name")
    public String name;
    @JsonProperty("native")
    public String _native;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String get_native() {
        return _native;
    }
}