package com.wucstone.thread.sync.condition;

import org.junit.Test;


public class SortedExecProcess_1 {
	
	private volatile int cnt = 0;
	
	public synchronized void first(){
		if(cnt % 3!=0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"--"+cnt+"--first function is running...");
		cnt++;
		notifyAll();
	}
	public synchronized void second(){
		if(cnt % 3!=1){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"--"+cnt+"--second function is running...");
		cnt++;
		notifyAll();
	}
	public synchronized void third(){
		if(cnt % 3!=2){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"--"+cnt+"--third function is running...");
		cnt++;
		notifyAll();
	}
	@Test
	public void testSortedProcess(){
		SortedExecProcess_1 proc = new SortedExecProcess_1();
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
