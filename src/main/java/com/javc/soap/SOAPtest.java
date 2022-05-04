package com.javc.soap;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;

import java.io.File;

public class SOAPtest {

    static {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public static void sendSoapRequest(File file) {
        Response response = RestAssured
                .given()
                .baseUri("http://www.dneonline.com")
                .basePath("/calculator.asmx")
                .header("SOAPAction", "http://tempuri.org/Add")
                .header("Content-Type", "text/xml; charset=utf-8")
                .body(file)
                .post();
        response.then().statusCode(200);
        response.prettyPrint();

        var xPathResult = response.xmlPath().get("//AddResult/text()");
        var result = Integer.parseInt(String.valueOf(xPathResult));
        Assertions.assertThat(result).isEqualTo(8);
    }

    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("src/main/java/com/wimix/automation/zegoal/ui/soapBody.xml");
        sendSoapRequest(file);
    }

    /*
    <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <soap:Body>
    <AddResponse xmlns="http://tempuri.org/">
      <AddResult>8</AddResult>
    </AddResponse>
  </soap:Body>
</soap:Envelope>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
  <soap:Body>
    <AddResponse xmlns="http://tempuri.org/">
      <AddResult>8</AddResult>
    </AddResponse>
  </soap:Body>
</soap:Envelope>
     */
}