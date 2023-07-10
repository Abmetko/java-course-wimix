package com.javc.hashCodeEquals_contract;

import java.util.HashMap;
import java.util.Map;

/**
 * src/main/resources/HashMap_scheme.png
 */
public class TestHashFunction {

    public static void main(String[] args) {
        Map<User3, Integer> map = new HashMap<>();

        map.put(new User3(30), 10);
        map.put(new User3(30), 10);
        map.put(new User3(30), 15);

        System.out.println(map.toString());
        //{com.javc.hashCodeEquals_contract.User3@3d=10, com.javc.hashCodeEquals_contract.User3@3d=10, com.javc.hashCodeEquals_contract.User3@3d=15}


        //В этом случае объект в хэшмэп будет только 1 т. к. hashCode и equals для ключа будут одни и те же,
        //будет просто перезапись данных в бакете.
        Map<String, Integer> map2 = new HashMap<>();

        map2.put("user", 10);
        map2.put("user", 10);
        map2.put("user", 15);

        System.out.println(map2.toString());
        //{user=15}

        System.out.println(2306996 % 16); //Например, тут для такого hashCode = 2306996 вызов хэш функции в HashMap будет равен --> 4.
        // И это и будет index бакета(node -->  Node(int hash, K key, V value, Node<K,V> next)) в массиве бакетов состоящем по умолчанию из 16 ячеек.
        // Если для несколько РАЗНЫХ объектов(node) будут одинаковые значения ХЭШ ФУНКЦИИ, то такой бакет, будет представлять из себя LinkedList
        // состоящий из нескольких node. Первая node будет хранить ссылку на вторую node. Вторая добавленная node будет хранить ссылку --> null.
        // В ИТОГЕ, когда мы вызываем метод get(Object key), то в начале происходит поиск по значению ХЭШ ФУНКЦИИ ключа,
        // и затем уже ищется конкретная node с таким же значением ХЭШ КОДА!!!!!!!!!!!!!!!!!!!
        // и далее проверяется equals() для объекта ключа. И если оба эти параметра совпадают - возвращается value.
    }
}