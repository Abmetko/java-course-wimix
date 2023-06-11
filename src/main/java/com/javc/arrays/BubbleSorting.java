package com.javc.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BubbleSorting {

    static int[] array = {1, 5, -9, 0, -12, 4, 6, 34};

    public static void main(String[] args) {
//        createNewArrayWithEvenNumbersByMeansOfStream();
        bubbleSorting();
    }

    public static void bubbleSorting() {
        int buffer;
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    isSorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    Создать новый массив содержащий четные числа из первого массива
     */
    public static void createNewArrayWithEvenNumbers() {
        int arraySize = 0;

        for (int i : array) {
            if (i % 2 == 0) {
                arraySize++;
            }
        }

        int[] newArray = new int[arraySize];
        int counter = 0;

        for (int i : array) {
            if (i % 2 == 0) {
                newArray[counter] = i;
                counter++;
            }
        }

        System.out.println(Arrays.toString(newArray));
    }

    public static void createNewArrayWithEvenNumbersByMeansOfStream() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] newArray = IntStream.of(array).filter(i -> i % 2 == 0).toArray();

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i : newArray) {
            sb.append(i);
            if(i != Arrays.stream(newArray).max().getAsInt()){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}