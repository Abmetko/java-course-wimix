package com.javc.equals;

import java.util.Objects;

public class TestObject {

    public String param;

    public TestObject(String param) {
        this.param = param;
    }

    //два разных объекта без переопределенного метода equals
    public static void equalsFalse() {
        Object obj_1 = new Object();
        Object obj_2 = new Object();
        System.out.println(obj_1.equals(obj_2)); //false
    }

    //две ссылочные переменные одного объекта
    public static void equalsTrue() {
        Object obj_1 = new Object();
        Object obj_2 = obj_1;
        System.out.println(obj_1.equals(obj_2)); //true
    }

    //в классе String метод equals переопределен
    public static void equalsTrue2() {
        String obj_1 = new String("1");
        String obj_2 = new String("1");
        System.out.println(obj_1.equals(obj_2)); //true
    }

    //два разных объекта но идентичных по содержанию, c переопределенным методом equals
    public static void equalsTrueWithOverrideEquals() {
        TestObject obj_1 = new TestObject("test");
        TestObject obj_2 = new TestObject("test");
        System.out.println(obj_1.equals(obj_2)); //true
    }

    public static void main(String[] args) {
        equalsFalse();
        equalsTrue();
        equalsTrueWithOverrideEquals();
        equalsTrue2();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestObject that = (TestObject) o;
        return Objects.equals(param, that.param);
    }
}