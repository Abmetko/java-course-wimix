package com.javc.patterns.singleton.lazyInitializationHolder;

import lombok.SneakyThrows;

public class SingletonWithHolder {

    private SingletonWithHolder() {
    }

    public static String getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final String instance = String.valueOf(System.currentTimeMillis());
    }

    @SneakyThrows
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println(SingletonWithHolder.getInstance());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(SingletonWithHolder.getInstance());
        });

        Thread thread3 = new Thread(() -> {
            System.out.println(SingletonWithHolder.getInstance());
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }
}