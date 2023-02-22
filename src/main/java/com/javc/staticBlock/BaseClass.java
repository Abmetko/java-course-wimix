package com.javc.staticBlock;

public abstract class BaseClass {

    public static final String time;

    static {
        System.out.println("This is static block of initialization...");
        time = String.valueOf(System.currentTimeMillis());
    }
}