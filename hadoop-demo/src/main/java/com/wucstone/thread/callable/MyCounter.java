package com.wucstone.thread.callable;

import java.util.concurrent.Callable;


public class MyCounter implements Callable<Integer>{

	private int[] arr=new int[10];
	private int sum=0;
	
	
	
	public MyCounter(int[] arr) {
		super();
		this.arr = arr;
	}



//	@Override
//	public void run() {
//		
//		for (int i = 0; i < arr.length; i++) {
//			sum+=arr[i];
//		}
//	System.out.println(Thread.currentThread().getName()+"from:"+arr[0]+"--to:"+arr[9]+"--"+sum);
//	
//	}



	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			Thread.currentThread().sleep(1000);
		}
		System.out.println(Thread.currentThread().getName()+"from:"+arr[0]+"--to:"+arr[9]+"--"+sum);
		
		return sum;
	}
}
