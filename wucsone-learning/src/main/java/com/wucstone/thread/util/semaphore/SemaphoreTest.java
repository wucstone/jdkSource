package com.wucstone.thread.util.semaphore;

import java.util.concurrent.Semaphore;

import org.junit.Test;

public class SemaphoreTest {
	
	@Test
    public void testSemaphore() {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        
        for(int i=0;i<N;i++)
            new SemaphoreThread(i,semaphore).start();
        
        while(true){}
    }

}
