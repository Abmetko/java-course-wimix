package com.javc.csv.open_csv;

import com.javc.csv.open_csv.beanBasedReadingWriting.Weather;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;

import java.io.*;
import java.util.List;

@SuppressWarnings("all")
public class BeanBasedReadingWriting {

    //каждая строка из CSV файла десериализуется в объект, где колонки сетаются в поля объекта
    public static List<Weather> readValue(String path, Class clazz) throws IOException {
        ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
        mappingStrategy.setType(clazz);

        Reader reader = new FileReader(path);
        CsvToBean cb = new CsvToBeanBuilder(reader)
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(mappingStrategy)
                .withSkipLines(1)
                .build();

        List<Weather> list = cb.parse();
        reader.close();
        return list;
    }

    public static <T> void writeValue(String path, List<T> list) throws Exception {
        Writer writer = new FileWriter(path);

        StatefulBeanToCsv sbc = new StatefulBeanToCsvBuilder(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();

        sbc.write(list);
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        List<Weather> list = readValue("src/main/resources/temperatures.CSV", Weather.class);
        list.stream().forEach(weather -> System.out.println(weather));

        writeValue("src/main/java/com/javc/csv/open_csv/written_csv.CSV", list);
    }
}