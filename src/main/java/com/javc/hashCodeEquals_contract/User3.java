package com.javc.hashCodeEquals_contract;

import java.util.Objects;

public class User3 {

    int age;

    public User3(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
