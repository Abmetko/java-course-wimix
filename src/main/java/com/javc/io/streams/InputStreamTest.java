package com.javc.io.streams;

import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class InputStreamTest {

    private final static StringBuilder stringBuilder = new StringBuilder();

    private static byte[] getBytes() throws IOException {
        byte[] bytes;
        FileInputStream intStream = new FileInputStream("src/main/java/com/javc/io/streams/file_2.txt");
        bytes = intStream.readAllBytes();
        intStream.close();
        return bytes;
    }

    public static String readData(Charset charset) throws IOException {
        InputStream inputStream = new FileInputStream("src/main/java/com/javc/io/streams/file_1.txt");
        byte[] bytes = inputStream.readAllBytes();

        Byte[] bytesArray = ArrayUtils.toObject(bytes);//1 byte may hold 1 character
        /*
        вывести на печать байты [-2, -1, 0, 72, 0, 101, 0, 108, 0, 108, 0, 111] для кодировки UTF-16,
        [72, 101, 108, 108, 111, 10, 119, 111, 114, 108, 100] для UTF-8.
         */
        System.out.println(Arrays.asList(bytesArray));

        inputStream.close();
        return new String(bytes, charset);//де кодировка(раскодировка) массива байт, при преобразовании в строку
    }

    public static String readData_2() throws IOException {
        FileReader fileReader = new FileReader("src/main/java/com/javc/io/streams/file.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        bufferedReader.lines().forEach(line -> stringBuilder.append(line).append("\n"));
        stringBuilder.setLength(stringBuilder.length() - 1);
        bufferedReader.close();
        fileReader.close();
        return stringBuilder.toString();
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
        OutputStreamTest.writeData_2(StandardCharsets.UTF_8);
        System.out.println(readData(StandardCharsets.UTF_8));
        System.out.println(readData(StandardCharsets.UTF_16));
        System.out.println("\n");

        OutputStreamTest.writeData_2(StandardCharsets.UTF_16);
        System.out.println(readData(StandardCharsets.UTF_8));
        System.out.println(readData(StandardCharsets.UTF_16));
        System.out.println("\n");

        System.out.println("new String(getBytes()): " + new String(getBytes()));
        System.out.println("new String(getBytes(), StandardCharsets.US_ASCII): " + new String(getBytes(), StandardCharsets.US_ASCII));
        System.out.println("new String(getBytes(), StandardCharsets.UTF_8): " + new String(getBytes(), StandardCharsets.UTF_8));
        System.out.println("new String(getBytes(), StandardCharsets.UTF_16): " + new String(getBytes(), StandardCharsets.UTF_16));

        System.out.println("\n");

        System.out.println("readData_2(): " + readData_2());
    }
}