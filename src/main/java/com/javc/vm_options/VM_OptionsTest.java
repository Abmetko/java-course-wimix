package com.javc.vm_options;

import java.util.Properties;

public class VM_OptionsTest {

    /*
    for VM_OptionsTest test run, we need to pass argument as "VM options" --> -Dexpected.value=100 -Ddisplayed.name=test

    it's the same as we call System.setProperty("expected.value", 100) and etc.
     */

    public static void main(String[] args) {
        int expectedValue = Integer.parseInt(System.getProperty("expected.value"));

        String displayedName = System.getProperty("displayed.name");

        System.out.println(expectedValue);//100
        System.out.println(displayedName);//test

        System.setProperty("displayed.name", "new_test");
        System.out.println(System.getProperty("displayed.name"));//new_test

        System.setProperty("expected.value", "200");
        System.out.println(System.getProperty("expected.value"));//200

        //or, to use Properties type
        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("expected.value"));//200
    }
}