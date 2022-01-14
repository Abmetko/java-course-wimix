package com.javc.streamAPI;

import java.util.Arrays;
import java.util.List;

public class TestStream_1 {

    public static void main(String[] args) {
        List<Integer>[] arrays = new List[]{Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5)};

        int value = Arrays.stream(arrays).mapToInt(array -> array
                .stream()
                .filter(i -> i % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum()).sum();

        System.out.println(value);
    }
}