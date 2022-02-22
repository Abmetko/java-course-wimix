package com.javc.dto.ipstack;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ip",
        "type",
        "continent_code",
        "continent_name",
        "country_code",
        "country_name",
        "region_code",
        "region_name",
        "city",
        "zip",
        "latitude",
        "longitude",
        "location"
})
public class IpStack {

    @JsonProperty("ip")
    public String ip;
    @JsonProperty("type")
    public String type;
    @JsonProperty("continent_code")
    public String continentCode;
    @JsonProperty("continent_name")
    public String continentName;
    @JsonProperty("country_code")
    public String countryCode;
    @JsonProperty("country_name")
    public String countryName;
    @JsonProperty("region_code")
    public String regionCode;
    @JsonProperty("region_name")
    public String regionName;
    @JsonProperty("city")
    public String city;
    @JsonProperty("zip")
    public String zip;
    @JsonProperty("latitude")
    public Double latitude;
    @JsonProperty("longitude")
    public Double longitude;
    @JsonProperty("location")
    public Location location;

    public String getIp() {
        return ip;
    }

    public String getType() {
        return type;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public String getContinentName() {
        return continentName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Location getLocation() {
        return location;
    }
}