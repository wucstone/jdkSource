package com.wucstone.thread.sync.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class AQSLock implements Lock{
	
	private AQSSync aqs;
	
	
	private class AQSSync extends AbstractQueuedSynchronizer	{
		
		@Override
		protected boolean tryAcquire(int arg) {
			
			int state = getState();
			Thread current = Thread.currentThread();
			int update = state + arg;
			if((state == 0 || current == getExclusiveOwnerThread())&& compareAndSetState(state, update)){
				setExclusiveOwnerThread(current);
				return true;
			}
			
			return false;
		}
		@Override
		protected boolean tryRelease(int arg) {
			
			int state = getState();
			int update = state - arg;
			Thread current = Thread.currentThread();
			
			if(current != getExclusiveOwnerThread()){
				throw new RuntimeException();
			}
			if(state > 1 && compareAndSetState(state, update)){
				return false;
			}
			if(state == 1){
				setState(update);
				setExclusiveOwnerThread(current);
				return true;
			}
			return false;
		}
	} 
	@Override
	public void lock() {
		aqs.acquire(1);
	}
	@Override
	public void unlock() {
		aqs.release(1);
	}
	

	@Override
	public void lockInterruptibly() throws InterruptedException {
		
	}
	@Override
	public boolean tryLock() {
		return false;
	}
	@Override
	public boolean tryLock(long time, TimeUnit unit)
			throws InterruptedException {
		return false;
	}
	@Override
	public Condition newCondition() {
		return null;
	}

	public AQSLock() {
		this.aqs = new AQSSync();
	}

	
}
