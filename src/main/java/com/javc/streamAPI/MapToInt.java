package com.javc.streamAPI;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToInt {

    private void transformStreamToIntStream() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        IntStream intStream = stream.mapToInt(i -> i);

        System.out.println(intStream.sum());
    }

    private void transformIntStreamToStream() {
        IntStream intStream = IntStream.rangeClosed(1, 5);

        System.out.println(intStream.boxed());
    }
}