package com.wucstone.thread.lock;

import com.wucstone.utils.ThreadPoolResource;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class TestConcurrentHashMap {


    @Test
    public  void testMap(){
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap();
        map.put("wuchuang",18);
        CountDownLatch latch = new CountDownLatch(10);
        ReentrantLock lock = new ReentrantLock();

        for(int i=0;i<10;i++){
            ThreadPoolResource.CALC_THREAD_POOL.submit(new Runnable() {
                @Override
                public void run() {
//                    synchronized (TestConcurrentHashMap.class){
                    lock.lock();
                        Integer integer = map.get("wuchuang");
                        integer++;
                        map.put("wuchuang",integer);
                        lock.unlock();
//                    }
                    latch.countDown();
                }
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map.get("wuchuang"));


    }



}
