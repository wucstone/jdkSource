package com.wucstone.thread.sync.AQS;

import org.junit.Test;

public class Sequence {
	
	private AQSLock lock = new AQSLock();
	
	private volatile int cnt = 0;
	
	public int getNext(){
		lock.lock();
		cnt++;
		lock.unlock();
		return cnt;
	}
	
	@Test
	public void testAQSLock(){
		
		Sequence seq =new Sequence();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					System.out.println(Thread.currentThread().getName()+"--"+seq.getNext());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
					
			@Override
			public void run() {
				while(true){
					System.out.println(Thread.currentThread().getName()+"--"+seq.getNext());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					System.out.println(Thread.currentThread().getName()+"--"+seq.getNext());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					System.out.println(Thread.currentThread().getName()+"--"+seq.getNext());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		while(true){}
		
		
	}

}
