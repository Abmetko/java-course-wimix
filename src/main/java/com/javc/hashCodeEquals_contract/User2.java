package com.javc.hashCodeEquals_contract;

import java.util.Objects;

public class User2 {

    int age;

    public User2(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User2 user2 = (User2) o;
        return age == user2.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}