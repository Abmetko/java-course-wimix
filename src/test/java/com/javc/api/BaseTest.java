package com.javc.api;

import com.javc.api.services.ClimateService;
import com.javc.api.services.IpStackService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
/*
@Execution(ExecutionMode.CONCURRENT) it's the same as junit.jupiter.execution.parallel.mode.default=concurrent
- for running test methods in class with concurrent mode.
@ResourceLock("BlaBla") is used to declare that the annotated test class or test method requires access to
a shared resource identified by a key.
*/

public abstract class BaseTest {

    protected ClimateService climateService;
    protected IpStackService ipStackService;

    @BeforeAll
    public void setUp() {
        climateService = new ClimateService();
        ipStackService = new IpStackService();
    }
}