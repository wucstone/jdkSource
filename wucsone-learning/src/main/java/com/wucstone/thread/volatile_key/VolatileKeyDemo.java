package com.wucstone.thread.volatile_key;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class VolatileKeyDemo extends Thread{
	
	
	private ReentrantLock lock;
	
	

	public VolatileKeyDemo(ReentrantLock lock) {
		super();
		this.lock = lock;
	}



	@Override
	public void run() {
		try {
			if(lock.tryLock(3000L,TimeUnit.MILLISECONDS)){
				System.out.println(Thread.currentThread().getName()+"tryLock...");
				lock.lock();
				System.out.println(Thread.currentThread().getName()+"do something...");
				try {
					lock.wait(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
