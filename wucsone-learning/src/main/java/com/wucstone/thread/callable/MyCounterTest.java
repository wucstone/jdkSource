package com.wucstone.thread.callable;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.Test;

public class MyCounterTest {
	
	private volatile List<Long> results=new ArrayList<Long>();  
	
	
	@Test
	public void testMyCounter() throws InterruptedException, ExecutionException{
		
		int[] list =new int[100];
		
		long sum=0L;
		
		for (int i = 0; i < list.length; i++) {
			list[i]=i;
		}
		
		for (int i = 0; i < 10; i++) {
			int[] subList=Arrays.copyOfRange(list, 10*i, 10*(i+1));
			MyCounter countor=new MyCounter(subList);
			FutureTask<Long> task = new FutureTask<Long>(countor);
			Thread t=new Thread(task);
			t.start();
			results.add(task.get());
		}
		
		for (int i = 0; i < results.size(); i++) {
			sum+=results.get(i);
		}
		System.out.println(sum);
		
	}

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		MyCounter countor=new MyCounter(latch,new int[]{1,2,3,5});
		FutureTask<Long> task = new FutureTask<Long>(countor);
		
		ThreadPoolExecutor exe_ = new ThreadPoolExecutor(10, 10, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		exe_.submit(task);
		Executor exe = Executors.newCachedThreadPool();
		exe.execute(task);
		try {
			System.out.println(task.get(1,TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
