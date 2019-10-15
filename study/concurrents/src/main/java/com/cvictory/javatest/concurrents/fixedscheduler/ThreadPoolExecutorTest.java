package com.cvictory.javatest.concurrents.fixedscheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cvictory ON 2018/8/1
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(3, 5,
                600L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        executorService.submit(new PrinterRunner(executorService, 600L));
        executorService.submit(new PrinterRunner(executorService, 1000L));
        executorService.submit(new PrinterRunner(executorService, 600L));

        executorService.submit(new PrinterRunner(executorService, 6000L));
        executorService.submit(new PrinterRunner(executorService, 600000L));
        Thread.sleep(20000);
        executorService.submit(new PrinterRunner(executorService, 600000L));
        executorService.submit(new PrinterRunner(executorService, 600000L));
    }
}
