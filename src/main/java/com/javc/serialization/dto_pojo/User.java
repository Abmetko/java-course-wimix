package com.javc.serialization.dto_pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "address",
        "age"
})
public class User {

    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("age")
    private Integer age;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}