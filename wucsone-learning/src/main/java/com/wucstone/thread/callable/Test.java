package com.wucstone.thread.callable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch=new CountDownLatch(10);
		
		 List<Future<Long>> results=new ArrayList<Future<Long>>();  
		long sum=0;
		long sum1=0;
		int[] list =new int[100];
		for (int i = 0; i < list.length; i++) {
			list[i]=i;
		}
		System.out.println("开始时间"+new Date().getTime());
	    ExecutorService exec=Executors.newFixedThreadPool(10);  
	    
		for (int i = 0; i < 10; i++) {
			System.out.println("进入for时间："+new Date().getTime());
			int[] subList=Arrays.copyOfRange(list, 10*i, 10*(i+1));
			MyCounter counter=new MyCounter(subList);
			results.add(exec.submit(counter));
			System.out.println("出for时间："+new Date().getTime());

		}
		
//		latch.await();
		
		for (int i = 0; i < results.size(); i++) {
			try {
				System.out.println("jinru  get");
				sum+=results.get(i).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("jieshu ");
		System.out.println(sum);
		System.out.println("结束时间1--"+new Date().getTime());
		for (int i = 0; i < list.length; i++) {
			sum1+=list[i];
		}
		System.out.println(sum1);
		System.out.println("结束时间2--"+new Date().getTime());
	}
	
	
	
	
}
