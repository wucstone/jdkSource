package com.wucstone.sort;

import org.junit.Test;

public class QuickSortedDemo {
	
	public int[] arrs={3,1,4,5,7,9,8};
	
	/**
	 * 冒泡排序
	 */
	@Test
	public void testSorted(){
		int count=0;
		for (int i = 0; i < arrs.length; i++) {
			for (int j = i+1; j < arrs.length; j++) {
				count++;
				int temp;
				if(arrs[i] > arrs[j]){
					temp=arrs[i];
					arrs[i]=arrs[j];
					arrs[j]=temp;
				}
			}
		}
		for (int i = 0; i < arrs.length; i++) {
			System.out.println(arrs[i]);
		}
		System.out.println(count+"次比较");
	}
	
	/**
	 * 快速排序
	 */
	@Test
	public void testQuickSorted(){
		int count=0;
		for (int j = 0; j < arrs.length; j++) {
			for (int i = 0; i < arrs.length-1; i++) {
				int temp;
				count++;
				if(arrs[i] > arrs[i+1]){
					temp=arrs[i];
					arrs[i]=arrs[i+1];
					arrs[i+1]=temp;
				}
			}
		}
		
		for (int i = 0; i < arrs.length; i++) {
			System.out.println(arrs[i]);
		}
		System.out.println(count+"次比较");

	}
	
	

}
