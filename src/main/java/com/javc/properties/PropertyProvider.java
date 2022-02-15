package com.javc.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

@SuppressWarnings("all")
public class PropertyProvider {

    private final static String FILE_PATH = "/application.properties";

    private static Properties properties;

    private PropertyProvider() {
    }

    public static String getProperty(String propertyName) {
        if (properties == null) {
            loadProperty();
        }
        String value = properties.getProperty(propertyName);
        if (value != null) {
            return value;
        } else {
            throw new IllegalArgumentException(String.format("Property %s is not found in file %s", propertyName, "/application.properties"));
        }
    }

    private static synchronized void loadProperty() {
        properties = new Properties();//нужна синхронизация
        try {
            properties.load(PropertyProvider.class.getResourceAsStream(FILE_PATH));///Users/andrey/Desktop/java-course-wimix/target/classes/application.properties
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public static void storeProperty(String propName, String propValue) {
        if (properties == null) {
            loadProperty();
        }
        properties.setProperty(propName, propValue);
        try {
            URL url = PropertyProvider.class.getResource(FILE_PATH);
            FileOutputStream fileOutputStream = new FileOutputStream(
                    url.getPath()); //file:/Users/andrey/Desktop/java-course-wimix/target/classes/application.properties
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}