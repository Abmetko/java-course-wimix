package com.javc.homework2;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "passport",
        "items"
})
public class User {

    @JsonProperty("name")
    public String name;

    public String getPassport() {
        return passport;
    }

    @JsonProperty("passport")
    public String passport;
    @JsonProperty("items")
    public List<Integer> items = null;
}