package com.javc.io;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderTest {

    public static void readData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/io/test.txt"));
            String lineWithText;
            //bufferedReader.lines();
            while ((lineWithText = bufferedReader.readLine()) != null) {
                System.out.println(lineWithText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static String readFileAsString(String file) {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static void main(String[] args) {
        readData();
    }
}