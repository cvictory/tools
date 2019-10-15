package com.cvictory.javatest.concurrents.fixedscheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cvictory ON 2018/8/1
 */
public class PrinterRunner implements Runnable {
    public static AtomicInteger num = new AtomicInteger(0);
    private Long sleepTime = 3000L;
    private ThreadPoolExecutor executorService;

//    public PrinterRunner() {
//    }

    public PrinterRunner(ThreadPoolExecutor executorService, long sleepTime) {
        this.sleepTime = sleepTime;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        int tmp = num.incrementAndGet();
        System.out.println("start" + tmp + "; " + executorService.getLargestPoolSize() +". " + Thread.currentThread().getName());
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end" + tmp);
    }
}
