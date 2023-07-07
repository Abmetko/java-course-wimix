package com.javc.hashCodeEquals_contract;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestUserWithHashCodeAndEqualsOvverading {

    public static void main(String[] args) {
        Map<String, User2> map = new HashMap<>();

        map.put("User1", new User2(20));
        map.put("User2", new User2(20));

        System.out.println(map.get("User1").equals(map.get("User2")));
        System.out.println(map.get("User1").hashCode());
        System.out.println(map.get("User2").hashCode());

        //true
        //20
        //20

        System.out.println("\n");

        Set<User2> set = new HashSet<>();
        set.add(map.get("User1"));
        set.add(map.get("User2"));
        System.out.println(set.size());
        //1
    }
}