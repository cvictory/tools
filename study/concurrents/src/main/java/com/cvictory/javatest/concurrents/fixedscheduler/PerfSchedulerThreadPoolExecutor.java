package com.cvictory.javatest.concurrents.fixedscheduler;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cvictory ON 2018/8/13
 */
public class PerfSchedulerThreadPoolExecutor {
    private static AtomicInteger MULTI_COUNT = new AtomicInteger(0);

    private static AtomicInteger SINGLE_COUNT = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("start main");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "FixedSchedulerThreadPoolExecutorTest");
                return thread;
            }
        });

        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new MultiLoopTask(), 1, 5, TimeUnit.SECONDS);


        System.out.println("end main");
    }


    private static class MultiLoopTask implements Runnable {

        private static Long start = System.nanoTime();

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(MULTI_COUNT.incrementAndGet() + "-m- " + (System.nanoTime() - start));
                runBiz();
            }
        }
    }

    private static class SingleTask implements Runnable {
        private static Long start = System.nanoTime();

        @Override
        public void run() {
            System.out.println(SINGLE_COUNT.incrementAndGet()+ "-s- " + (System.nanoTime() - start));
            runBiz();
        }
    }

    public static void runBiz() {
        try {
            Thread.sleep(80L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
