package com.javc.enums;

import java.util.Arrays;

import static com.javc.enums.DaysOfWeek.SUNDAY;

public class TestEnum {

    public static void main(String[] args) {
        Arrays.stream(DaysOfWeek.values())
                .forEach(i -> System.out.println(i.getFullName() + " " + i.getShortName()));

        System.out.println(SUNDAY.getFullName());
    }
}