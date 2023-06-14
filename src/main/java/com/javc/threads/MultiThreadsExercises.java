package com.javc.threads;

import lombok.SneakyThrows;

public class MultiThreadsExercises {

    @SneakyThrows
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println(Thread.currentThread().getName()), "thread1");
        Thread thread2 = new Thread(() -> System.out.println(Thread.currentThread().getName()), "thread2");
        Thread thread3 = new Thread(() -> System.out.println(Thread.currentThread().getName()), "thread3");
        Thread thread4 = new Thread(() -> System.out.println(Thread.currentThread().getName()), "thread4");
        Thread thread5 = new Thread(() -> System.out.println(Thread.currentThread().getName()), "thread5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        //Ожидать завершения каждого из порожденных потоков
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();

        System.out.println(Thread.currentThread().getName());
    }
}

//thread3
//thread5
//thread4
//thread1
//thread2
//main