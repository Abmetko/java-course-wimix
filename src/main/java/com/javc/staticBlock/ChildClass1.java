package com.javc.staticBlock;

public class ChildClass1 extends BaseClass {

    public ChildClass1() {
        System.out.println("This is " + Thread.currentThread().getName() + ", time = " + time);
    }
}