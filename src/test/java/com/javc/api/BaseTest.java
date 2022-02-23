package com.javc.api;

import com.javc.api.services.ClimateService;
import com.javc.api.services.IpStackService;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    protected ClimateService climateService;
    protected IpStackService ipStackService;

    @BeforeAll
    public void setUp() {
        climateService = new ClimateService();
        ipStackService = new IpStackService();
    }

    static {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}