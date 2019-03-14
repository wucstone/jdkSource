package com.wucstone.sort;

public class QuickSortedCustomer {
	
	
	public static void main(String[] args) {
		int[] arry={1,5,8,9,4,6,8,3};
		for (int i = 0; i < arry.length; i++) {
			System.out.print(arry[i]+",");
		}
		System.out.println("hello world!!");
		sort(arry,0,7);
		for (int i = 0; i < arry.length; i++) {
			System.out.print(arry[i]+",");
		}
	}
	
	public static void sort(int[] arry,int low,int high){
		
		
		int start = low;
		int end = high;
		int key = arry[low];
		
		
		
		while(end > start){
			while(end > start && arry[end] >= key){
				end--;
			}
			if(arry[end] < key){
				int temp = arry[end];
				arry[end] = arry[start];
				arry[start] = temp;
			}
			
			while(end > start && arry[start] <= key){
				start++;
			}
			if(arry[start] > key){
				int temp = arry[end];
				arry[end] = arry[start];
				arry[start] = temp;
			}
			  for(int i = 0; i<arry.length; i++){
		             System.out.print(arry[i]+",");
		         }
	 	       System.out.println("");
		}
		
		if(start > low) sort(arry,low,start-1);
		if(end < high) sort(arry,end+1,high);
	}

}
