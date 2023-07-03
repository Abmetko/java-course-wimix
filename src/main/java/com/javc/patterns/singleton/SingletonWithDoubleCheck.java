package com.javc.patterns.singleton;

import lombok.SneakyThrows;

import java.util.stream.IntStream;

public class SingletonWithDoubleCheck {

    private static volatile String instance;

    private SingletonWithDoubleCheck() {
    }

    public static String getInstance() {
        String result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Object.class) {
            if (instance == null) {
                instance = String.valueOf(System.currentTimeMillis());
            }
            return instance;
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 1000).forEach(thread -> {
            Thread th = new Thread(() -> {
                System.out.println(SingletonWithDoubleCheck.getInstance());
            });
            th.start();
        });
    }
}