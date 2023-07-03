package com.javc.patterns.strategy;

public class UserSignUpStrategy implements SignUpStrategy {

    @Override
    public void signUp() {
        System.out.println("\"User\" sign up");
    }
}