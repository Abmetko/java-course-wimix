package com.javc.staticBlock;

import static com.javc.staticBlock.BaseClass.time;

public class ChildClass2 {

    public ChildClass2() {
        System.out.println("This is " + Thread.currentThread().getName() + ", time = " + time);
    }
}