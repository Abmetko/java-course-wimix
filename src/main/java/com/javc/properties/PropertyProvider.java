package com.javc.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@SuppressWarnings("all")
public class PropertyProvider {

    private final static String FILE_PATH = "/application.properties";
    private static Properties properties;

    private PropertyProvider() {
    }

    public static synchronized String getProperty(String propertyName) {
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

    private static void loadProperty() {
        System.out.println(Thread.currentThread().getName());//to ckeck without synchronization
        properties = new Properties();
        try {
            properties.load(PropertyProvider.class.getResourceAsStream(FILE_PATH));///Users/andrey/Desktop/java-course-wimix/target/classes/application.properties
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setProperty(String key, String value) {
        if (properties == null) {
            loadProperty();
        }
        properties.setProperty(key, value);
    }

    public static synchronized void storeProperty(String propName, String propValue) {
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

    public static Map<Object, Object> getMap() {
        if (properties == null) {
            loadProperty();
        }
        Map<Object, Object> map = new HashMap<>();
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
        entrySet.forEach(entry -> map.put(entry.getKey(), entry.getValue()));
        return map;
    }
}