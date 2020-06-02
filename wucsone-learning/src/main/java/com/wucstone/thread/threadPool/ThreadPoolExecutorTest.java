package com.wucstone.thread.threadPool;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

	
	 public static void main(String[] args) {

		 ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 1000, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
		 Future<Object> future = executor.submit(new Callable<Object>() {

			 @Override
			 public Object call() throws Exception {

			 	throw new RuntimeException("123");
//				 return null;
			 }
		 });

		 try {
			 future.get();
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 } catch (ExecutionException e) {
			 e.printStackTrace();
		 }

	 }
}
