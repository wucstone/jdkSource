package com.wucstone.thread.sync.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class SortedExecProcess_2 {
	
	ReentrantLock lock = new ReentrantLock();
	Condition first=lock.newCondition();
	Condition second=lock.newCondition();
	Condition third=lock.newCondition();
	private volatile int cnt = 0;
	
	
	public void first(){
		lock.lock();
		if(cnt % 3 !=0){
			try {
				first.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("first function is running...");
		cnt++;
		second.signal();
		lock.unlock();
	}
	public void second(){
		lock.lock();
		if(cnt % 3 !=1){
			try {
				second.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("second function is running...");
		cnt++;
		third.signal();
		lock.unlock();
	}
	public void third(){
		lock.lock();
		if(cnt % 3 !=2){
			try {
				third.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("third function is running...");
		cnt++;
		first.signal();
		lock.unlock();
	}

	@Test
	public void testSortedProcess(){
		SortedExecProcess_2 proc = new SortedExecProcess_2();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					proc.first();
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
					proc.second();
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
					proc.third();
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
