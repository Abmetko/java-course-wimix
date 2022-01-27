package com.javc.homework2;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "users"
})
public class Users {

    public List<User> getUsers() {
        return users;
    }

    @JsonProperty("users")
    public List<User> users = null;
}