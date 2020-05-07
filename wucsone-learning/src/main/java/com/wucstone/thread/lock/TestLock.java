package com.wucstone.thread.lock;

import com.wucstone.utils.ThreadPoolResource;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestLock {


    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    @Test
    public void testReentrantReadWriteLock() {
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        ThreadPoolResource.CALC_THREAD_POOL.submit(new Runnable() {
            @Override
            public void run() {
                boolean flag = writeLock.tryLock();
                if(flag){
                    try {
                        System.out.println(Thread.currentThread().getName()+"--"+flag);
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        writeLock.unlock();
                    }
                }
            }
        });
        while (true){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
