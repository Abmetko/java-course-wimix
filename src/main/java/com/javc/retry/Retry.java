package com.javc.retry;

import lombok.SneakyThrows;

import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

public class Retry {

    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public void whileTrue(int pollingInterval, int timeout, Supplier<Boolean> supplier) {
        long startTime = System.currentTimeMillis();
        while (supplier.get()) {
            if (System.currentTimeMillis() - startTime > timeout) {
                throw new TimeoutException();
            }
            sleep(pollingInterval);
        }
    }
}