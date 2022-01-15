package com.javc.threads;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(currentThread().getName());
    }

    public static void main(String[] args) {
        //Первый вариант создания потока на основе своего класса расширяющего Thread.
        MyThread thread = new MyThread();
        thread.start();

        //Второй вариант, на основе реализации интерфейса Runnable.
        Runnable thread2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(currentThread().getName());
            }
        };
        thread2.run();

        //Третий вариант, на основе класса Thread, передав в конструктор реализацию интерфейса Runnable.
        Thread thread3 = new Thread(() -> System.out.println(currentThread().getName()));
        thread3.start();
    }
}