package com.javc;

import java.util.stream.IntStream;

@SuppressWarnings("all")
public class InfiniteLoopTest {

    public static void endless() {
        for (; ; ) {
            IntStream.rangeClosed(1, 10).forEach(System.out::println);
        }
    }

    public static void endless2() {
        while (true) {
            IntStream.rangeClosed(1, 10).forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        endless();
    }
}