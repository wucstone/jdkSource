package com.wucstone.thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

public class CyclicTest {

	
	@Test
	public void testCyclic(){
		int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N);
        for(int i=0;i<N;i++){
        	new CyclicThread(barrier).start();
        }
        while(true){}
	}
}
