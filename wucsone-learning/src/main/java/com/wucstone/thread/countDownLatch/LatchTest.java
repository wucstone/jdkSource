package com.wucstone.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class LatchTest {

	@Test
	public void testLatch(){
		
		CountDownLatch latch=new CountDownLatch(2);
		Thread t1=new LatchThread(latch);
		Thread t2=new LatchThread(latch);
		t1.start();
		t2.start();
		
		
         try {
        	System.out.println("等待2个子线程执行完毕...");
			latch.await();
			System.out.println("2个子线程已经执行完毕");
			System.out.println("继续执行主线程");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
