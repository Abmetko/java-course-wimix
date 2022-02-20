package com.javc.io.streams;

import org.apache.commons.lang3.ArrayUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class InputStreamTest {

    private final static StringBuilder stringBuilder = new StringBuilder();

    public static String readData() throws IOException {
        InputStream inputStream = new FileInputStream("src/main/java/com/javc/io/streams/file.txt");
        byte[] bytes = inputStream.readAllBytes();

        Byte[] bytesArray = ArrayUtils.toObject(bytes);//1 byte may hold 1 character
        System.out.println(Arrays.asList(bytesArray));//вывести на печать байты [72, 101, 108, 108, 111, 10, 119, 111, 114, 108, 100]

        inputStream.close();
        return new String(bytes, StandardCharsets.US_ASCII);//де кодировка(раскодировка) массива байт, при преобразовании в строку
    }

    public static String readDataWithScanner() throws IOException {
        InputStream inputStream = new FileInputStream("src/main/java/com/javc/io/streams/file.txt");
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            stringBuilder.append(scanner.next()).append("\n");
        }
        inputStream.close();
        scanner.close();

        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readData());//StandardCharsets.US_ASCII
        System.out.println(readDataWithScanner());//с де-кодировкой по умолчанию UTF-8
    }
}