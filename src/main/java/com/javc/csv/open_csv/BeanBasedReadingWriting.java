package com.javc.csv.open_csv;

import com.javc.csv.open_csv.beanBasedReadingWriting.Weather;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;

import java.io.*;
import java.util.List;

public class BeanBasedReadingWriting {

    //каждая строка из CSV файла десериализуется в объект, где колонки сетаются в поля объекта
    public static <T> List<T> readValue(String path, Class<T> cls) throws IOException {
        ColumnPositionMappingStrategy<T> mappingStrategy = new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(cls);

        Reader reader = new FileReader(path);
        CsvToBean<T> cb = new CsvToBeanBuilder<T>(reader)
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(mappingStrategy)
                .withSkipLines(1)
                .build();

        List<T> list = cb.parse();
        reader.close();
        return list;
    }

    public static <T> void writeValue(String path, List<T> list) throws Exception {
        Writer writer = new FileWriter(path);

        StatefulBeanToCsv<T> sbc = new StatefulBeanToCsvBuilder<T>(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();

        sbc.write(list);
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        List<Weather> list = readValue("src/main/resources/temperatures.CSV", Weather.class);

        writeValue("src/main/java/com/javc/csv/open_csv/written_csv.CSV", list);
    }
}