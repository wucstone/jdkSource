package com.wucstone.thread.sync.customerLock;

import org.junit.Test;



public class DemoLockTest {
	
	/**
	 * 自定义锁测试
	 */
	@Test
	public void testReentrantLock() {
		
		Sequence s = new Sequence();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					System.out.println(Thread.currentThread().getName()+"--"+s.getNext());
				}
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					System.out.println(Thread.currentThread().getName()+"--"+s.getNext());
				}
			}
		}).start();
	}
	
	/**
	 * 自定义锁测试是否可重入
	 */
	@Test
	public void testIsReentrantLock() {

		ABC abc = new ABC();
		new Thread(new Runnable() {
			@Override
			public void run() {
				abc.a();
			}
		}).start();
	}

}
