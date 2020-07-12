package com.davis.course;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	private static final int NUM_THREADS = 10;
	private static final CountDownLatch cdl = new CountDownLatch(NUM_THREADS);
	
	public static void main(String[] args) throws InterruptedException {
		
		final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
		
		for (int i = 0; i < NUM_THREADS; i++)
			executorService.submit(() -> {
				
				System.out.println("Thread " + 
						Thread.currentThread().getName() + " ready!");

				cdl.countDown();				
			});
	
		cdl.await();
		System.out.println("All threads are now ready to accept work...");
		
		executorService.shutdown();
	}	
}
