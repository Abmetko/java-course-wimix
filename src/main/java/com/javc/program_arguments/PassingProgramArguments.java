package com.javc.program_arguments;

import java.util.stream.Stream;

public class PassingProgramArguments {

    /**
     * Running with command line:
     * cd /Users/andrey/Desktop/java-course-wimix/src/main/java/com/javc/program_arguments/
     * java PassingProgramArguments.java 100 200 300
     */
    public static void main(String[] args) {
        Stream.of(args).forEach(System.out::println);
    }
}