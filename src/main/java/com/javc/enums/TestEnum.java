package com.javc.enums;

import java.util.Arrays;

public class TestEnum {

    public static void main(String[] args) {
        Arrays.stream(DaysOfWeek.values())
                .forEach(i -> System.out.println(i.getFullName() + " " + i.getShortName()));
    }
}