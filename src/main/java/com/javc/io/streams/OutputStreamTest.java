package com.javc.io.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/*
Разница между InputStream и Reader.
Как InputStream, так и Reader могут использоваться для чтения данных (чтения данных из файла или чтения данных из сокета),
основные различия заключаются в следующем:
InputStream используется для чтения двоичных чисел (потоков байтов), а Reader - для чтения текстовых данных,
то есть символов Unicode. Так в чем же разница между двоичными числами и текстовыми данными?
По сути, все содержимое считывается байтами. Чтобы преобразовать байты в текст, необходимо указать метод кодирования.
Считыватель может закодировать поток байтов и преобразовать его в текст. Конечно, в этом процессе преобразования используется
метод кодирования, который по умолчанию использует метод кодирования системы для кодирования потока байтов. Также можно явно
указать метод кодирования, например «UTF-8». Хотя эта концепция очень проста, Java-программисты часто допускают ошибки кодирования,
и наиболее распространенной ошибкой является не указание метода кодирования. При чтении файлов или чтении данных из сокетов,
если не указан правильный метод кодирования, считанные данные могут быть искажены, что может привести к потере данных.


Во-вторых, разница между FileInputStream и FileReader:
FileInputStream и FileReader имеют сходные различия, они используются для чтения данных из файла,
но FileInputStream используется для чтения двоичных данных (байтовый поток) из файла,
а FileReader используется для чтения символьных данных из файла.
FileReader наследуется от InputStreamReader, он использует либо системный метод кодирования по умолчанию,
либо метод кодирования, используемый InputStreamReader. Следует отметить, что InputStreamReader кэширует кодировку символов,
поэтому после создания объекта InputStreamReader, если вы измените кодировку символов, это не будет иметь никакого эффекта.
 */
public class OutputStreamTest {

    //записываем байты в файл
    public static void writeData_1() throws IOException {
        byte[] bytes = {72, 101, 108, 108, 111, 10, 119, 111, 114, 108, 100};

        OutputStream outputStream = new FileOutputStream("src/main/java/com/javc/io/streams/file_2.txt");
        outputStream.write(bytes);
        outputStream.close();
    }

    //в String каждому char присваивается byte значение и далее задаем кодировку
    public static void writeData_2(Charset charset) throws IOException {
        byte[] bytes = "Hello\nworld".getBytes(charset);
        OutputStream outputStream = new FileOutputStream("src/main/java/com/javc/io/streams/file_1.txt");
        outputStream.write(bytes);
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        writeData_1();
        writeData_2(StandardCharsets.UTF_8);
    }
}