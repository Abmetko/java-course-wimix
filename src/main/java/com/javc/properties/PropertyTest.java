package com.javc.properties;

import static com.javc.properties.PropertyProvider.getProperty;

public class PropertyTest {

    public static void main(String[] args) {
        System.out.println(getProperty("test.type"));//статический импорт
    }
}