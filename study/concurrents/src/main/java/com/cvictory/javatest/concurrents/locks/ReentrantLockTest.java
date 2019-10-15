package com.cvictory.javatest.concurrents.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cvictory ON 2018/8/8
 */
public class ReentrantLockTest {

    static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        try {
            new Thread(new Task1()).start();
            new Thread(new Task2()).start();
        } finally {
            System.out.println("end..");
        }
    }

    static class Task1 implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("task1 wait..");
                Thread.sleep(30000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("task1 end..");
                lock.unlock();
            }
        }
    }

    static class Task2 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(300L);
                lock.lock();
                System.out.println("task2 wait..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("task2 end..");
                lock.unlock();
            }
        }
    }


}
