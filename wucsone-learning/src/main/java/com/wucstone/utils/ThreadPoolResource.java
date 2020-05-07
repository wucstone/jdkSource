package com.wucstone.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolResource {

    public static final ExecutorService CALC_THREAD_POOL = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors() + 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
            new ThreadFactoryBuilder().setNameFormat("application-thread-pool").build());

    public static final ExecutorService IO_THREAD_POOL = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors() * 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
            new ThreadFactoryBuilder().setNameFormat("application-thread-pool").build());
}
