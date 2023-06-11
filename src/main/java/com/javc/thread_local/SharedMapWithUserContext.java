package com.javc.thread_local;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedMapWithUserContext implements Runnable {

    /**
     * В этом примере два порожденных потока кладут в одну статическую Map<Integer, Context> два значения.
     * В отличие от ThreadLocal,
     * который способен обеспечить хранение индивидуального значения для каждого потока. Статическое тут поле чтобы не
     * плодить объекты.
     * <p>
     * We can rewrite our example to store the user Context instance using a ThreadLocal.
     * Each thread will have its own ThreadLocal instance.
     * <p>
     * When using ThreadLocal, we need to be very careful because every ThreadLocal instance
     * is associated with a particular thread. In our example, we have a dedicated thread
     * for each particular userId, and this thread is created by us, so we have full control over it.
     */
    public static Map<Integer, Context> userContextPerUserId = new ConcurrentHashMap<>();

    private final Integer userId;

    public SharedMapWithUserContext(int i) {
        this.userId = i;
    }

    @Override
    public void run() {
        String userName = Thread.currentThread().getName();
        userContextPerUserId.put(userId, new Context(userName));
    }

    @SneakyThrows
    public static void main(String[] args) {
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();

        Thread.sleep(1000);//дать время чтобы два порожденных потока заполнили мап

        Assertions.assertThat(SharedMapWithUserContext.userContextPerUserId.size()).isEqualTo(2);
    }
}

class Context {

    @SuppressWarnings("FieldCanBeLocal")
    private final String userName;

    public Context(String userName) {
        this.userName = userName;
    }
}