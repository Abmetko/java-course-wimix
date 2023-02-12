package com.javc.thread_local;

import com.javc.dto.gorest.User;

public class ThreadLocalTest {

    /**
     * При инициализации объекта с помощью статического метода java.lang.ThreadLocal#withInitial(java.util.function.Supplier),
     * передаем ему и сетаем объект User. Который в дальнейшем можно извлечь java.lang.ThreadLocal#get() для Main потока.
     */
    private static final ThreadLocal<User> threadLocal = ThreadLocal.withInitial(() -> {
        User user = new User();
        user.setName("Main thread");
        return user;
    });

    public static void main(String[] args) throws InterruptedException {

        class MyThread extends Thread {

            @Override
            public void run() {
                User user = new User();
                user.setName(Thread.currentThread().getName());
                threadLocal.set(user);
                System.out.println(threadLocal.get().getName());
            }
        }

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        thread1.join();//ждать смерти этого порожденного потока
        thread2.join();

        //после того как два порожденных потока умрут - выполнится метод main потока
        System.out.println(threadLocal.get().getName());
    }
}