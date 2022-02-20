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
    @JsonProperty("is_eu")
    public Boolean isEu;

}