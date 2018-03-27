package com.wucstone.thread.callable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

	public static void main(String[] args) {
		 List<Future<Integer>> results=new ArrayList<Future<Integer>>();  
		int sum=0;
		int sum1=0;
		int[] list =new int[100];
		for (int i = 0; i < list.length; i++) {
			list[i]=i;
		}
		System.out.println(new Date().getTime());
	    ExecutorService exec=Executors.newCachedThreadPool();  
	    
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit((new MyCounter(Arrays.copyOfRange(list, 10*i, 10*(i+1))))));
		}
		
		for (int i = 0; i < results.size(); i++) {
			try {
				sum+=results.get(i).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sum);
		System.out.println(new Date().getTime());
		for (int i = 0; i < 100; i++) {
			sum1+=i;
		}
		System.out.println(sum1);
		System.out.println(new Date().getTime());
	}
	
	
	
	
}
