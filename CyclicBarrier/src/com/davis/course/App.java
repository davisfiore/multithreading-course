package com.davis.course;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	private static final int NUM_THREADS = 10;
	private static final CyclicBarrier cb = new CyclicBarrier(NUM_THREADS, () -> {
			System.out.println("Barrier reached!");		
	});
	
	public static void main(String[] args) throws InterruptedException {
		
		final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
		
		for (int i = 0; i < NUM_THREADS; i++)
			executorService.submit(() -> {
				
				try {
					System.out.println(Thread.currentThread().getName() + " ready");
					cb.await();
				} catch (InterruptedException |
					BrokenBarrierException e) {
					e.printStackTrace();
				}	
			});
	
		executorService.shutdown();
	}	
}
