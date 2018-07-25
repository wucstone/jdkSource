package com.wucstone.zookeeper.distlock.ii;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

public class ZKTest {
	
	private volatile int count=0;
	
	
	private CountDownLatch latch=new CountDownLatch(10);
	
	@Test
	public void testZookeeper() throws IOException, InterruptedException, KeeperException{
		
		
		for (int i = 0; i <10; i++) {
			new Thread() {
				@Override
				public void run() {
					try {
						ZKUtils zkUtils = new ZKUtils(count);
//						ZooKeeper zoo = zkUtils.getConnection();
						
						String current=zkUtils.getDistributeLock();
						
						if(current!=null){
							System.out.println(Thread.currentThread().getName()+"do something");
//							Thread.sleep(1000);
							zkUtils.closeLock(current);
							latch.countDown();
						}
						
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
					} catch (KeeperException e) {
						e.printStackTrace();
					}
					
				}
			}.start();
			
		}
		latch.await();
		System.out.println("所有线程执行结束！！");
	}

}
