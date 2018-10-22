package com.wucstone.sort;

import java.util.ArrayList;
import java.util.LinkedList;

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
    public void testQuickSort(){
        int[] arr = {3,2,7,10,1,9,0,5};
        quickSort(arr,0,arr.length-1);
        for(int i : arr){
        	System.out.print(i+" ");
        }
    }
    private int partition(int[] a, int low,int high){
        int pivot = a[low];
       
        while(low<high){
            while(low<high && a[high]>=pivot){
            	high--;
            } 
            a[low] = a[high];

            while(low<high && a[low]<=pivot){
            	low++;
            } 
            a[high]=a[low];
        }
        a[low] = pivot;
        return low;
    }

    public void quickSort(int[] data,int low,int high){
        if(low<high){
            int pivot = partition(data,low,high);
            quickSort(data,low,pivot-1);

            quickSort(data,pivot+1,high);

        }
    }
	
	

}
