package com.javc.csv.open_csv.beanBasedReadingWriting;

import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;

public class BeanBasedReadingWriting {

    //каждая строка из CSV файла десериализуется в объект, где колонки сетаются в поля объекта
    public static <OBJECT> List<OBJECT> readValue(Reader reader, Class<OBJECT> cls, int skippedLines) {
        List<OBJECT> list;
        ColumnPositionMappingStrategy<OBJECT> mappingStrategy = new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(cls);

        CsvToBean<OBJECT> cb = new CsvToBeanBuilder<OBJECT>(reader)
                .withIgnoreQuotations(true)
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(mappingStrategy)
                .withSkipLines(skippedLines)
                .build();

        list = cb.parse();
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <OBJECT> void writeValue(Writer writer, List<OBJECT> list) {
        StatefulBeanToCsv<OBJECT> sbc = new StatefulBeanToCsvBuilder<OBJECT>(writer)
                .withApplyQuotesToAll(false)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();
        try {
            sbc.write(list);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader("src/main/resources/Users.CSV");
        List<Temperature> list = readValue(reader, Temperature.class, 1);

        Writer writer = new FileWriter("src/main/java/com/javc/csv/open_csv/beanBasedReadingWriting/written_csv.CSV");
        writeValue(writer, list);
    }
}