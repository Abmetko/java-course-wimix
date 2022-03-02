package com.javc.api;

import com.javc.api.services.ClimateService;
import com.javc.api.services.IpStackService;
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
}