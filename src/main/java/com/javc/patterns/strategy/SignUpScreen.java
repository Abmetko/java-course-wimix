package com.javc.patterns.strategy;

public class SignUpScreen {

    private final SignUpStrategy signUpStrategy;

    public SignUpScreen(SignUpStrategy signUpStrategy) {
        this.signUpStrategy = signUpStrategy;
    }

    public void signUp() {
        signUpStrategy.signUp();
    }
}