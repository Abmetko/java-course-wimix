package com.javc.configuration;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.IOException;

public class TestConfiguration {

    public static void main(String[] args) throws ConfigurationException, IOException {
        Configuration configuration = new ConfigurationResolverBuilder()
                .withEnvironmentProperties()
                .withSystemProperties()
                .withClassPathProperties("/application.properties")
                .build();

        System.out.println(configuration.getString("env.id")); //Environment variables: env.id=develop
        System.out.println(configuration.getString("os.type")); //VM options: -Dos.type=mac
        System.out.println(configuration.getString("prop.value")); //application.properties --> prop.value=2
    }
}