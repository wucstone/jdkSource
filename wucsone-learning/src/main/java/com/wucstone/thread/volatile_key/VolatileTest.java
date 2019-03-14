package com.wucstone.thread.volatile_key;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class VolatileTest {
	
	
	@Test
	public void testMap(){
		
//		HashMap<K, V>
//		Hashtable<K, V>
//		ConcurrentHashMap<K, V>
		
//		ThreadPoolExecutor executor=new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
				
		ExecutorService executors= Executors.newFixedThreadPool(3);
		ReentrantLock lock=new ReentrantLock();
		
		for (int i = 0; i < 3; i++) {
			executors.submit(new VolatileKeyDemo(lock));
		}
		while(true){
			
		}
		
		
	}
	
	

}
