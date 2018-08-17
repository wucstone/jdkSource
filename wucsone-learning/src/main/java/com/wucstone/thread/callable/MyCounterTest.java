package com.wucstone.thread.callable;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

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

}
