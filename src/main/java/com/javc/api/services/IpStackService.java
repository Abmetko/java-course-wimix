package com.javc.api.services;

import com.javc.dto.ipstack.IpStack;
import io.restassured.http.ContentType;

import static com.javc.properties.PropertyProvider.getProperty;
import static io.restassured.RestAssured.given;

public class IpStackService {

    public void getIpData() {
        given()
                .queryParam("access_key", getProperty("ipstack.com.access.key"))
                .when()
                .get("http://api.ipstack.com/37.214.31.173")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(IpStack.class);
    }
}