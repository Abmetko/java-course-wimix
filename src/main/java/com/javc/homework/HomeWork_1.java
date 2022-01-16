package com.javc.homework;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Используя BufferedReader(), с помощью цикла положить каждую строку из файла в объект коллекции.
Далее, с помощью цикла вывести на печать каждый элемент коллекции.
Извлечь данные из файла с помощью stream API, поместить их в новую коллекцию.
Далее, с помощью stream API вывести каждый элемент коллекции на печать.
 */
public class HomeWork_1 {

    private static final List<String> LIST = new ArrayList<>();

    private static BufferedReader bufferedReader;

    public static void readPrintValuesWithLoop() throws IOException {
        bufferedReader = new BufferedReader(new FileReader("src/main/java/com/generic/names.txt"));

        bufferedReader.readLine();//skip header

        while (bufferedReader.ready()) {
            LIST.add(bufferedReader.readLine());
        }

        for (String i : LIST) {
            System.out.println(i);
        }
        bufferedReader.close();
        LIST.clear();
    }

    public static void readPrintValuesWithStream() throws IOException {
        bufferedReader = new BufferedReader(new FileReader("src/main/java/com/generic/names.txt"));

        bufferedReader.readLine();//skip header

        bufferedReader.lines()
                .forEach(LIST::add);
        bufferedReader.close();

        LIST.forEach(System.out::println);
        LIST.clear();
    }

    public static void main(String[] args) throws IOException {
//        String[] arr = {"andrey", "stasia", "liza", "olga"};
//        List<String> list = Arrays.stream(arr).map(i -> i.toUpperCase()).collect(Collectors.toList());
//        System.out.println(list.get(0));

        readPrintValuesWithLoop();
        readPrintValuesWithStream();
    }
}