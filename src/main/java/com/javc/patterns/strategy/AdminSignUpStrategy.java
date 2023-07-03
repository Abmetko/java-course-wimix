package com.javc.patterns.strategy;

public class AdminSignUpStrategy implements SignUpStrategy {

    @Override
    public void signUp() {
        System.out.println("\"Admin\" sign up");
    }
}