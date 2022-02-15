package com.javc.properties;

import static com.javc.properties.PropertyProvider.getProperty;
import static com.javc.properties.PropertyProvider.setProperty;

public class PropertyTest {

    public static void main(String[] args) {
        System.out.println(getProperty("prop.value"));

        PropertyProvider.storeProperty("user.name", "Jack");///Users/andrey/Desktop/java-course-wimix/target
        System.out.println(getProperty("user.name"));

        setProperty("hello", "world");
        System.out.println(getProperty("hello"));
    }
}