package com.javc.arrays.examples;

import java.util.Arrays;

public class ArrayExercises {

    static int[] array = {1, 2, 3, 4, 5, 6, 7, 100, -200, 8, 0};

    public static void reverseArray() {
        for (int i = 0; i < array.length / 2; i++) {
            int buffer = array[array.length - i - 1];
            array[array.length - i - 1] = array[i];
            array[i] = buffer;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void findMaxValueFromArray() {
        int max = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            if (max < array[i + 1]) {
                max = array[i + 1];
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        findMaxValueFromArray();
    }
}