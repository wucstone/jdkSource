package com.wucstone.zookeeper.distlock.lockwatcher;

import org.junit.Test;

public class DistributedLoclTest {
	
	@Test
	public void testLock() throws InterruptedException{
		
		for (int i = 0; i < 10; i++) {
			DistributedLock lock   = new DistributedLock("node-wuc-02:2181","lock");
			lock.lock();
			Thread.sleep(1000);
			//共享资源
			if(lock != null)
			lock.unlock();  
			
		}
	}

}
