package com.qh.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorUtil {

    private static ThreadPoolExecutor threadPoolExecutor;

    public static ThreadPoolExecutor getInstance() {
        if (threadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorUtil.class) {
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = new ThreadPoolExecutor(10, 50, 60, TimeUnit.SECONDS,
                            new LinkedBlockingQueue<>());
                }
            }
        }
        return threadPoolExecutor;
    }
}