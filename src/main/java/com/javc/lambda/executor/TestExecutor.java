package com.javc.lambda.executor;

public class TestExecutor {

    public static void textExecutor(Executor executor) {
        executor.execute();
    }

    public static void main(String[] args) {
        textExecutor(() -> System.out.println("This is test of Executor"));

        textExecutor(() -> System.out.println(1 + 2));
    }
}