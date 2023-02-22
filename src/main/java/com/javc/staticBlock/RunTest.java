package com.javc.staticBlock;

public class RunTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(ChildClass1::new);
        Thread thread2 = new Thread(ChildClass1::new);
        Thread thread3 = new Thread(ChildClass2::new);
        Thread thread4 = new Thread(ChildClass2::new);
        Thread thread5 = new Thread(ChildClass1::new);
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
