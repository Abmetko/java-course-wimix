package com.javc.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static byte[] getArrayOfBytes(String path) {
        InputStream inputStream = Utils.class.getResourceAsStream(path);
        try {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}