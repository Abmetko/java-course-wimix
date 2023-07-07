package com.javc.hashCodeEquals_contract;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestUserWithHashCodeOnly {

    public static void main(String[] args) {
        Map<String, User3> map = new HashMap<>();

        map.put("User1", new User3(20));
        map.put("User2", new User3(20));

        System.out.println(map.get("User1").equals(map.get("User2")));
        System.out.println(map.get("User1").hashCode());
        System.out.println(map.get("User2").hashCode());

        //false
        //51
        //51

        //Коллизия в hashCode — это ситуация, в которой два РАЗНЫХ объекта имеют ОДИНАКОВОЕ значение hashCode.
        System.out.println("\n");

        Set<User3> set = new HashSet<>();
        set.add(map.get("User1"));
        set.add(map.get("User2"));
        System.out.println(set.size());
        //2
    }
}