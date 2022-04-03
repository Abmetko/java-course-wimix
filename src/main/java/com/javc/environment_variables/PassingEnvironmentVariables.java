package com.javc.environment_variables;

public class PassingEnvironmentVariables {

    public static String getEnv() {
        return System.getenv("javc.env"); //Environment variables: mvn test javc.env=develop
    }

    public static void main(String[] args) {
        System.out.println(getEnv());

        System.out.println(args[2]);
    }
}