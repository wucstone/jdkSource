package com.wucstone.thread.sync.customerLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class CustomerReentrantLock implements Lock{
	
	
	private boolean isLocked;
	
	private Thread lockThread;

	private int lockCount = 0; 
	
	@Override
	public synchronized void lock() {
		
		Thread currentThread = Thread.currentThread();
		
		//自旋
		while(isLocked && lockThread != currentThread){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isLocked = true ;
		lockThread = currentThread;
		lockCount ++;
	}
	
	@Override
	public synchronized void unlock() {
		
		if(lockThread == Thread.currentThread()){
			lockCount --;
			if(lockCount == 0){
				isLocked = false;
				notify();
			}
		}
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
