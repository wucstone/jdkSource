package com.wucstone.thread.threadPool;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

	
	 public static void main(String[] args) {
		  ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		  for (int i = 0; i < 10; i++) {
			  final int index = i;
		      try {
		    	  Thread.sleep(index * 100);
		      }catch (InterruptedException e) {
		    	  e.printStackTrace();
		      }
			  cachedThreadPool.shutdown();
		  }
		  System.out.println(Thread.currentThread().getName());

		 ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 1000, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
		 executor.shutdown();


	 }
}
