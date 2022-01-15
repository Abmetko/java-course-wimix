package com.javc.serialization.homework;

import com.javc.serialization.base.Human;
import lombok.SneakyThrows;

import java.io.*;

@SuppressWarnings("all")
public class GenericDeserializer {

    private static final String FILE_PATH = "src/main/java/com/javc/serialization/base/file.txt";

    public static void writeObject(File file, Object obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    @SneakyThrows
    public static <T> T getObject(File file, Class<T> cls) {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Object obj = (T) objectInputStream.readObject();
        objectInputStream.close();
        return (T) obj;
    }

    @SneakyThrows
    public static <T> T getObject_2(File file, Class<T> cls) {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        T obj = (T) objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }

    /**
     * Human.class - возвращает объект Class с типом Human.
     *
     * @see <a href="https://docs.oracle.com/javase/tutorial/reflect/class/classNew.html">
     * https://docs.oracle.com/javase/tutorial/reflect/class/classNew.html</a>
     */
    @SneakyThrows
    public static void main(String[] args) {
        writeObject(new File(FILE_PATH), new Human("John", "Minsk", 15));

        System.out.println(getObject(new File(FILE_PATH), Human.class).address);
    }
}