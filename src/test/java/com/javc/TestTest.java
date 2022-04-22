package com.javc;

public class TestTest {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        int[] a2 = a1;

        a2[0] = 0;
        System.out.println(a1[0]);
        System.out.println(a1[1]);
        System.out.println(a1[2]);
    }
}