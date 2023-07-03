package com.javc.integration;

import org.junit.jupiter.api.Test;

//The execution of the surefire plugin includes all classes whose name starts with Test,
// or ends with Test, Tests or TestCase. In contrast, the failsafe plugin executes test
// methods in classes whose name starts with IT, or ends with IT or ITCase.
//
//This is where we can find the documentation regarding test inclusion for surefire,
// and here is the one for failsafe.
public class IntegrationTestIT {

    @Test
    public void integrationTest() {
        System.out.println("------------------------------ Integration test ------------------------------");
    }
}