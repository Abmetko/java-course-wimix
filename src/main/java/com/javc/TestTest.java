package com.javc;

import java.util.HashMap;
import java.util.Map;

public class TestTest {

    public static Map<Character, Integer> getAmount(String string) {
        char[] arr = string.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        //qqwwwi
        for (char c : arr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        map.entrySet().removeIf((entry) -> {
            return (entry.getValue() == 1);
        });
        return map;
    }

    public static void main(String[] args) {
        getAmount("qqwwwi");
        System.out.println("");
    }
}
