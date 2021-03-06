package com.davis.course;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class App {

	private static final int NUM_THREADS = 8;
	private static final int MAX_NUM = 1000;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
		
		for (int i=0; i < NUM_THREADS; i++) {
			executorService.submit(() -> System.out.println(ThreadLocalRandom.current().nextInt(MAX_NUM)));
		}
		
		executorService.shutdown();
	}	
}
