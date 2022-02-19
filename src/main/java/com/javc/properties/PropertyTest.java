package com.javc.properties;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.javc.properties.PropertyProvider.*;

public class PropertyTest {

    public static void main(String[] args) {
        System.out.println(getProperty("prop.value"));

        PropertyProvider.storeProperty("user.name", "Jack");///Users/andrey/Desktop/java-course-wimix/target
        System.out.println(getProperty("user.name"));

        setProperty("hello", "world");
        System.out.println(getProperty("hello"));

        System.out.println(getMap());

        System.out.println("\nTest with multithreading & synchronization:\n");

        IntStream threads = IntStream.rangeClosed(1,10);
        List<Thread> threadList = threads.mapToObj(thread -> new Thread(() -> System.out.println(getProperty("jdbc.url"))))
                .collect(Collectors.toList());

        threadList.forEach(Thread::start);
    }
}