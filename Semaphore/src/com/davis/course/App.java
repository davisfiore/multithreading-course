package com.davis.course;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
		
	public static void main(String[] args) {
	
		final AtomicInteger counter = new AtomicInteger(0);
		
		final Semaphore sem = new Semaphore(3);

		final ExecutorService executorService = Executors.newFixedThreadPool(100);
		
		for (int i = 0; i < 100; i++)
			executorService.submit(() -> {
				try {
					sem.acquire();
					final int currCount = counter.incrementAndGet();
					
					System.out.println("The current number of threads " +
							"Accessing the resource is " + currCount);
	
					counter.decrementAndGet();
					sem.release();
		
				} catch (InterruptedException e) {e.printStackTrace();}
			});
		
		executorService.shutdown();
	}	
}
