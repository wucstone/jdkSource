package com.wucstone.thread.lock;

import com.wucstone.utils.ThreadPoolResource;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {


    @Test
    public void testLock(){

        ReentrantLock reentrantLock = new ReentrantLock();

        for(int i=0;i<20;i++){
            ThreadPoolResource.CALC_THREAD_POOL.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        reentrantLock.tryLock(2, TimeUnit.SECONDS);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

    }



}
