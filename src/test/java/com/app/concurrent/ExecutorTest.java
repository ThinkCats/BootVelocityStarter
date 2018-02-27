package com.app.concurrent;

import java.util.concurrent.*;

/**
 * test some executor
 *
 * @author WangLei
 * on 2018/2/26
 */
public class ExecutorTest {

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(20);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 50, TimeUnit.MILLISECONDS, queue);
        poolExecutor.setRejectedExecutionHandler((r, executor) -> System.out.println("Current Pool is full"));

        Runnable t1 = new TestThread(queue);
        Runnable t2 = new TestThread(queue);
        Runnable t3 = new TestThread(queue);
        Runnable t4 = new TestThread(queue);
        Runnable t5 = new TestThread(queue);
        Runnable t6 = new TestThread(queue);
        Runnable t7 = new TestThread(queue);

        poolExecutor.execute(t1);
        poolExecutor.execute(t2);
        poolExecutor.execute(t3);
        poolExecutor.execute(t4);
        poolExecutor.execute(t5);
        poolExecutor.execute(t6);
        poolExecutor.execute(t7);

        poolExecutor.shutdown();
    }
}

class TestThread implements Runnable {

    private BlockingQueue<Runnable> queue;

    public TestThread(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running ...");
        System.out.println("Queue Remaining: " + queue.remainingCapacity());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}