package com.javc.dto.ipstack;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "geoname_id",
        "capital",
        "languages",
        "country_flag",
        "country_flag_emoji",
        "country_flag_emoji_unicode",
        "calling_code",
        "is_eu"
})
public class Location {

    @JsonProperty("geoname_id")
    public Integer geonameId;
    @JsonProperty("capital")
    public String capital;
    @JsonProperty("languages")
    public List<Language> languages = null;
    @JsonProperty("country_flag")
    public String countryFlag;
    @JsonProperty("country_flag_emoji")
    public String countryFlagEmoji;
    @JsonProperty("country_flag_emoji_unicode")
    public String countryFlagEmojiUnicode;
    @JsonProperty("calling_code")
    public String callingCode;

    public Integer getGeonameId() {
        return geonameId;
    }

    public String getCapital() {
        return capital;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public String getCountryFlagEmoji() {
        return countryFlagEmoji;
    }

    public String getCountryFlagEmojiUnicode() {
        return countryFlagEmojiUnicode;
    }

    public String getCallingCode() {
        return callingCode;
    }

    public Boolean getEu() {
        return isEu;
    }

    @JsonProperty("is_eu")
    public Boolean isEu;

}