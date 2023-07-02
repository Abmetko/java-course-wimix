package com.javc.default_methods;

public interface Animal {

    default void bark() {
        System.out.println("Default bark!");
    }
}