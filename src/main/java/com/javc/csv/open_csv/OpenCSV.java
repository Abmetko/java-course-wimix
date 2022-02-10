package com.javc.csv.open_csv;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class OpenCSV {

    public static CSVParser getParser() {
        return new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();
    }

    public static List<String[]> readAllStrings(Reader reader, CSVParser parser, int skipLines) throws IOException, CsvException {
        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(skipLines)
                .withCSVParser(parser)
                .build();

        List<String[]> strings = csvReader.readAll();
        reader.close();
        csvReader.close();
        return strings;
    }

    public static void csvWriterAll(List<String[]> stringArray, File file) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(file));
        writer.writeAll(stringArray);
        writer.close();
    }

    public static void main(String[] args) throws IOException, CsvException {
        Reader reader = new FileReader(OpenCSV.class.getResource("/temperatures.CSV").getPath());
        List<String[]> strings = readAllStrings(reader, getParser(), 1);
        strings.forEach(line -> System.out.println(Arrays.toString(line)));
        csvWriterAll(strings, new File("src/main/resources/writtenAll.CSV"));
    }
}