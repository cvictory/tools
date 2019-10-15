package com.cvictory.javatest.concurrents.fixedscheduler;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author cvictory ON 2018/8/1
 */
public class FixedSchedulerThreadPoolExecutorTest {


    public static void main(String[] args) {
        System.out.println("start main");
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "FixedSchedulerThreadPoolExecutorTest");
                return thread;
            }
        });

        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new PrinterRunner(scheduledThreadPoolExecutor, 500), 3, 5, TimeUnit.SECONDS);
        System.out.println("end main");
    }


}
