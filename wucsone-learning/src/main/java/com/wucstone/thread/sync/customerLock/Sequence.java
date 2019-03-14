package com.wucstone.thread.sync.customerLock;

public class Sequence {
	
	private static long pointer = 0L;
	private static CustomerReentrantLock lock = new CustomerReentrantLock();
	
	public static synchronized long getNext(){
		lock.lock();
		pointer++;
		lock.unlock();
		return pointer;
	}

}
