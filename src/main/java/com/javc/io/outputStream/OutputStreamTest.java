package com.javc.io.outputStream;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class OutputStreamTest {

    @SneakyThrows
    public static void main(String[] args) {
        String text = "HHHddd";
        File outputFile = new File("src/main/java/com/javc/io/outputStream/test.txt");

        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        fileOutputStream.write(text.getBytes(StandardCharsets.UTF_8));

        FileInputStream fileInputStream = new FileInputStream(outputFile);

//        byte[] byteArray = fileInputStream.readAllBytes();
//        System.out.println(Arrays.toString(byteArray));


        StringBuilder sb = new StringBuilder();

        int i;
        while ((i = fileInputStream.read()) != -1) {
            sb.append(i);
            sb.append(",");
        }
        fileInputStream.close();
        fileOutputStream.close();
        System.out.println(sb.substring(0, sb.length() - 1));

        System.out.println(Arrays.toString(sb.toString().getBytes()));
    }
}