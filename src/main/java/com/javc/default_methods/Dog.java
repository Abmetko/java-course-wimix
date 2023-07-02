package com.javc.default_methods;

public class Dog implements Animal {

    @Override
    public void bark() {
        System.out.println("Dog's bark!");
    }
}