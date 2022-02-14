package com.javc.csv.open_csv.beanBasedReadingWriting;

import com.opencsv.CSVWriter;
import com.opencsv.bean.*;

import java.io.*;
import java.util.List;

public class BeanBasedReadingWriting {

    //каждая строка из CSV файла десериализуется в объект, где колонки сетаются в поля объекта
    public static <T> List<T> readValue(Reader reader, Class<T> cls, int skippedLines) throws IOException {
        ColumnPositionMappingStrategy<T> mappingStrategy = new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(cls);

        CsvToBean<T> cb = new CsvToBeanBuilder<T>(reader)
                .withIgnoreQuotations(true)
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(mappingStrategy)
                .withSkipLines(skippedLines)
                .build();

        return cb.parse();
    }

    public static <T> void writeValue(Writer writer, List<T> list) throws Exception {
        StatefulBeanToCsv<T> sbc = new StatefulBeanToCsvBuilder<T>(writer)
                .withApplyQuotesToAll(false)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();

        sbc.write(list);
    }

    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader("src/main/resources/temperatures.CSV");
        List<Temperature> list = readValue(reader, Temperature.class, 1);
        reader.close();

        Writer writer = new FileWriter("src/main/java/com/javc/csv/open_csv/beanBasedReadingWriting/written_csv.CSV");
        writeValue(writer, list);
        writer.close();
    }
}