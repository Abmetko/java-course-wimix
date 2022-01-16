package com.javc.varArgs;

import java.util.Arrays;

public class VarArgs {

    public static void varArgsTest(String... arg) {
        System.out.println("Всего аргументов: " + arg.length); //arg - это массив аргументов

        Arrays.stream(arg).forEach(System.out::println);
        System.out.print("\n");
    }

    public static void main(String[] args) {
        varArgsTest("1", "2", "3");
        varArgsTest("100");
    }
}