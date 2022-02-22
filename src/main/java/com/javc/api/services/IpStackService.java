package com.javc.api.services;

import com.javc.dto.ipstack.IpStack;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.javc.properties.PropertyProvider.getProperty;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class IpStackService {

    //for request & response logging
    static {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public static void main(String[] args) {
        IpStackService ipStackService = new IpStackService();
        System.out.println(ipStackService.getSpecificValue());
    }

    public IpStack getIpStack() {
        return given()
                .queryParam("access_key", getProperty("ipstack.com.access.key"))
                .when()//syntactic sugar, it returns the same RequestSpecification
                .get("http://api.ipstack.com/37.214.31.173")
                .then()
                .assertThat()//syntactic sugar
                .statusCode(200)//validate status code
                .extract()
                .as(IpStack.class);//mapping a response body to object
    }

    public Response getResponse() {
        return given()
                .queryParam("access_key", getProperty("ipstack.com.access.key"))
                .when()//syntactic sugar, it returns the same RequestSpecification
                .get("http://api.ipstack.com/37.214.31.173")//returns Response
                .then()
                .assertThat()
                .body("location.capital", equalTo("Minsk"))//validate specific field
                .body("location.languages.name", hasItems("Belarusian", "Russian"))//check that all values are in json array
                .contentType(ContentType.JSON)//validate response header
                .statusCode(200)
                .extract()
                .response();//returns Response
    }

    public String getSpecificValue() {
        return given()
                .queryParam("access_key", getProperty("ipstack.com.access.key"))
                .when()//syntactic sugar, it returns the same RequestSpecification
                .get("http://api.ipstack.com/37.214.31.173")//returns Response
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .body()
                .path("location.languages[0].name");//Belarusian
    }
}

/*
{
    "ip": "37.214.31.173",
    "type": "ipv4",
    "continent_code": "EU",
    "continent_name": "Europe",
    "country_code": "BY",
    "country_name": "Belarus",
    "region_code": "MA",
    "region_name": "Mogilev",
    "city": "Mahilyow",
    "zip": "212001",
    "latitude": 53.900001525878906,
    "longitude": 30.33329963684082,
    "location": {
        "geoname_id": 625665,
        "capital": "Minsk",
        "languages": [
            {
                "code": "be",
                "name": "Belarusian",
                "native": "Беларуская"
            },
            {
                "code": "ru",
                "name": "Russian",
                "native": "Русский"
            }
        ],
        "country_flag": "https://assets.ipstack.com/flags/by.svg",
        "country_flag_emoji": "🇧🇾",
        "country_flag_emoji_unicode": "U+1F1E7 U+1F1FE",
        "calling_code": "375",
        "is_eu": false
    }
}
 */