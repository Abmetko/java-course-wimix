package com.javc.patterns.strategy;

public class UserStrategy implements Strategy {

    @Override
    public void signUp() {
        System.out.println("\"Dog\" sign up");
    }
}