package com.wucstone.thread.sync.customerLock;

public class ABC {
	
	private CustomerReentrantLock lock = new CustomerReentrantLock();
	
	public void a(){
		
		lock.lock();
		System.out.println("调用方法a");
		b();
		lock.unlock();
	}
	
	public void b(){
		lock.lock();
		System.out.println("调用方法b");
		lock.unlock();
	}

}
