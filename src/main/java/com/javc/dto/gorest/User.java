package com.javc.dto.gorest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("email")
    private String email;
    @JsonProperty("status")
    private String status;
}