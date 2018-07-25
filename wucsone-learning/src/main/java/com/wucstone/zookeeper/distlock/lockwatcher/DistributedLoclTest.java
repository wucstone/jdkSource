package com.wucstone.zookeeper.distlock.lockwatcher;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class DistributedLoclTest {
	
	private CountDownLatch latch=new CountDownLatch(10);
	
	@Test
	public void testLock() throws InterruptedException{
		
		for (int i = 0; i < 10; i++) {
			new Thread(){
				public void run() {
					DistributedLock lock   = new DistributedLock("localhost:2181","wuc");
					lock.lock();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//共享资源
					if(lock != null)
					lock.unlock();  
					
					latch.countDown();
				}
				
			}.start();
			
			
		}
		latch.await();
		System.out.println("所有任务执行结束");
	}

}
