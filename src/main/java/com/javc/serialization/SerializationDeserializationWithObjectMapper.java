package com.javc.serialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

//библиотека Jackson для работы с сериализацией/десериализацией объектов JSON
public class SerializationDeserializationWithObjectMapper {

    @SneakyThrows
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        //ObjectMapper API
        ObjectMapper mapper = new ObjectMapper();
        var path = "src/main/java/com/javc/serialization/user.json";

//        //сериализация данных объекта в файл(json формат)
//        mapper.writeValue(new File(path), new Human("John", "DC", 15));

        //десериализация данных из файла в java объект
//        Human human = mapper.readValue(new File(path), Human.class);
//        System.out.println(human.age);//вывод на печать поля объекта --> 80
//        human.print();

        //десериализация данных из строки в java объект
        String jsonString = "[{\"name\":\"Tom\",\"address\":\"LA\",\"age\":90},{\"name\":\"John\",\"address\":\"LA\",\"age\":90}]";

        List<Human> human2 = mapper.readValue(jsonString, new TypeReference<List<Human>>() {});
        System.out.println(human2.get(1).toString());//вывод на печать поля объекта --> 60
        System.out.println("My name is " + human2.get(1).getName());
    }
}