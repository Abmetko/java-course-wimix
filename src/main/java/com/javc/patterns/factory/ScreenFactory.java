package com.javc.patterns.factory;

import com.javc.enums.Screen;

public class ScreenFactory {

    public BaseScreen getScreen(Screen type) {
        return switch (type) {
            case SPLASH -> new SplashScreen();
            case SIGN_IN -> new LoginScreen();
            case MAIN -> new MainScreen();
            default -> throw new IllegalArgumentException("screen name is incorrect:" + type);
        };
    }
}