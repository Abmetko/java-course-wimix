package com.javc.program_arguments;

import java.util.stream.Stream;

public class PassingProgramArguments {

    public static void main(String[] args) {
        Stream.of(args).forEach(System.out::println); //Program arguments: arg1 arg2 arg3

        System.out.println(System.getProperty("javc.env")); //VM options: -Djavc.env=develop

        //Running with command line: java -Djavc.env=develop PassingProgramArguments.java arg1 arg2 arg3
    }
}