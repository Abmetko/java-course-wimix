package com.javc.csv.open_csv.feeder;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

/*
В случае, если необходимо извлекать данные из таблицы в течении сессии, и делать это необходимо,
например, в разное время, при этом, данные из таблицы должны читаться последовательно.
*/
public class CSVFeeder {

    private static final String FILE_PATH = "src/main/java/com/javc/csv/open_csv/beanBasedReadingWriting/written_csv.CSV";
    private static CSVReader csvReader;

    private CSVFeeder() {
    }

    public static CSVReader getCsvReaderInstance() {
        if (csvReader == null) {
            try {
                csvReader = new CSVReaderBuilder(new FileReader(FILE_PATH))
                        .withSkipLines(0)
                        .build();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvReader;
    }

    /**
     * Обращаясь к объекту
     * каждый раз происходит чтение новой строки
     * с помощью метода
     * {@link CSVReader#readNext()}
     * <p/>
     * Синхронизированный метод поможет работать последовательно с данными таблицы в условиях много поточности.
     */
    public static synchronized String[] readLineByLineFromCsvFile() {
        try {
            return getCsvReaderInstance().readNext();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeCsvReader() {
        try {
            getCsvReaderInstance().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 30)
                .asDoubleStream()
                .parallel()//параллельно будем обращаться к таблице и извлекать данные
                .forEach(i -> System.out.println(Arrays.asList(readLineByLineFromCsvFile())));

        closeCsvReader();
    }
}