package com.javc.configuration;

import org.apache.commons.configuration2.*;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConfigurationResolverBuilder {

    private static CompositeConfiguration configuration;

    public ConfigurationResolverBuilder() {
        configuration = new CompositeConfiguration();
    }

    public ConfigurationResolverBuilder withSystemProperties() {
        configuration.addConfiguration(new SystemConfiguration());
        return this;
    }

    public ConfigurationResolverBuilder withEnvironmentProperties() {
        configuration.addConfiguration(new EnvironmentConfiguration());
        return this;
    }

    public ConfigurationResolverBuilder withClassPathProperties(String classPaths) throws ConfigurationException, IOException {
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();

        InputStream resourceAsStream = this.getClass().getResourceAsStream(classPaths);

        if (resourceAsStream != null) {
            InputStreamReader reader = new InputStreamReader(resourceAsStream);
            propertiesConfiguration.read(reader);
            reader.close();
        }

        configuration.addConfiguration(propertiesConfiguration);
        return this;
    }

    public Configuration build() {
        return configuration;
    }
}