package com.wucstone.thread.util.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class LatchThread  extends Thread{

	
	private CountDownLatch latch;
	
	
	
	public LatchThread(CountDownLatch latch) {
		super();
		this.latch = latch;
	}


	@Override
	public void run() {
		try {
            System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
           Thread.sleep(3000);
           latch.countDown();
           System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕-1");
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
	}
}
