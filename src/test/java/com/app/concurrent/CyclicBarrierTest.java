package com.app.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier Test
 *
 * @author WangLei
 * on 2018/2/27
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        Runnable lastTask = () -> System.out.println("this is last Task");
        CyclicBarrier barrier = new CyclicBarrier(5, lastTask);
        new SubTask("A", barrier).start();
        new SubTask("B", barrier).start();
        new SubTask("C", barrier).start();
        new SubTask("D", barrier).start();
        new SubTask("E", barrier).start();
    }
}

class SubTask extends Thread {
    private String name;
    private CyclicBarrier cyclicBarrier;

    SubTask(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("SubTask " + name + " Start Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SubTask " + name + " Complete");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

