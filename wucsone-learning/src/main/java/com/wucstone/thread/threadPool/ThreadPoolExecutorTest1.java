package com.wucstone.thread.threadPool;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest1 {
	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		ThreadPoolExecutor exec =new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new BlockingQueue<Runnable>() {
			
			@Override
			public <T> T[] toArray(T[] a) {
				return null;
			}
			
			@Override
			public Object[] toArray() {
				return null;
			}
			
			@Override
			public int size() {
				return 0;
			}
			
			@Override
			public boolean retainAll(Collection<?> c) {
				return false;
			}
			
			@Override
			public boolean removeAll(Collection<?> c) {
				return false;
			}
			
			@Override
			public Iterator<Runnable> iterator() {
				return null;
			}
			
			@Override
			public boolean isEmpty() {
				return false;
			}
			
			@Override
			public boolean containsAll(Collection<?> c) {
				return false;
			}
			
			@Override
			public void clear() {
				
			}
			
			@Override
			public boolean addAll(Collection<? extends Runnable> c) {
				return false;
			}
			
			@Override
			public Runnable remove() {
				return null;
			}
			
			@Override
			public Runnable poll() {
				return null;
			}
			
			@Override
			public Runnable peek() {
				return null;
			}
			
			@Override
			public Runnable element() {
				return null;
			}
			
			@Override
			public Runnable take() throws InterruptedException {
				return null;
			}
			
			@Override
			public boolean remove(Object o) {
				return false;
			}
			
			@Override
			public int remainingCapacity() {
				return 0;
			}
			
			@Override
			public void put(Runnable e) throws InterruptedException {
				
			}
			
			@Override
			public Runnable poll(long timeout, TimeUnit unit)
					throws InterruptedException {
				return null;
			}
			
			@Override
			public boolean offer(Runnable e, long timeout, TimeUnit unit)
					throws InterruptedException {
				return false;
			}
			
			@Override
			public boolean offer(Runnable e) {
				return false;
			}
			
			@Override
			public int drainTo(Collection<? super Runnable> c, int maxElements) {
				return 0;
			}
			
			@Override
			public int drainTo(Collection<? super Runnable> c) {
				return 0;
			}
			
			@Override
			public boolean contains(Object o) {
				return false;
			}
			
			@Override
			public boolean add(Runnable e) {
				return false;
			}
		}, new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				return null;
			}
		}, new RejectedExecutionHandler() {
			
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
