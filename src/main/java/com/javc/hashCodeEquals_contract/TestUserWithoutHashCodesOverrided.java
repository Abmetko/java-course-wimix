package com.javc.hashCodeEquals_contract;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestUserWithoutHashCodesOverrided {

    public static void main(String[] args) {
        Map<String, User> map = new HashMap<>();

        map.put("User1", new User(20));
        map.put("User2", new User(20));

        System.out.println(map.get("User1").equals(map.get("User2")));
        System.out.println(map.get("User1").hashCode());
        System.out.println(map.get("User2").hashCode());

        //true
        //1144748369
        //340870931

        //Получилась ситуация, когда два объекта абсолютно эквивалентны,
        // но при этом их хэш разный.
        System.out.println("\n");

        Set<User> set = new HashSet<>();
        set.add(map.get("User1"));
        set.add(map.get("User2"));
        System.out.println(set.size());
        //2
        //А должно было быть 1, потому как объекты по логике эквивалентны, но хэш у них по факту разный.
    }
}