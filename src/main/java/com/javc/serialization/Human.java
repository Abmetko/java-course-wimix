package com.javc.serialization;

public class Human {

    public String name = "test";
    public String address = "test";
    public int age = 10;
    public Human() {
    }

    public Human(String name, String address, int age) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}