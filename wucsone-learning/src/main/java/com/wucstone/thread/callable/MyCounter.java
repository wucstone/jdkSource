package com.wucstone.thread.callable;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;


public class MyCounter implements Callable<Long>{

	private int[] arr=new int[10];
	private Long sum=0L;
	private CountDownLatch latch;
	
	
	
	
	public MyCounter(CountDownLatch latch,int[] arr) {
		super();
		this.arr = arr;
		this.latch=latch;
	}
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
	public Long call() throws Exception {
		System.out.println("call调用时间："+new Date().getTime());
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		Thread.currentThread().sleep(1000);
//		latch.countDown();
//		System.out.println(Thread.currentThread().getName()+"from:"+arr[0]+"--to:"+arr[arr.length-1]+"--"+sum);
		
		return sum;
	}
}
