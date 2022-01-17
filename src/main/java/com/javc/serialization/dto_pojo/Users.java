package com.javc.serialization.dto_pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@SuppressWarnings("all")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "users"
})
public class Users {

    @JsonProperty("users")
    private List<User> users = null;

    @JsonProperty("users")
    public List<User> getUsers() {
        return users;
    }

    @JsonProperty("users")
    public void setUsers(List<User> users) {
        this.users = users;
    }
}