package com.javc.io.streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class InputStreamTest {

    private final static StringBuilder stringBuilder = new StringBuilder();


    public static String readData() throws IOException {
        InputStream inputStream = new FileInputStream("src/main/java/com/javc/io/streams/file.txt");
        byte[] bytes = inputStream.readAllBytes();
        inputStream.close();
        return new String(bytes);
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
        System.out.println(readData());
        System.out.println(readDataWithScanner());
    }
}