package com.javc.patterns.singleton;

import lombok.SneakyThrows;

import java.util.stream.IntStream;

public class LazySingleton {

    private static String instance;

    private LazySingleton() {
    }

    public static String getInstance() {
        if (instance == null) {
            instance = String.valueOf(System.currentTimeMillis());
        }
        return instance;
    }

    @SneakyThrows
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 1000).forEach(thread -> {
            Thread th = new Thread(() -> {
                System.out.println(LazySingleton.getInstance());
            });
            th.start();
        });
    }
}