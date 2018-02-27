package com.app.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author WangLei
 * on 2018/2/27
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            final int num = i;
            Runnable run = () -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " Get Acquire: " + num);
                    Thread.sleep(2000);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + " Release Acquire:" + num);
                    System.out.println("Current Allow Task Num:" + semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executorService.execute(run);
        }
        executorService.shutdown();
    }
}
