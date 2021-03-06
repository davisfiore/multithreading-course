package com.davis.course;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class App {

	private static final int NUM_THREADS = 8;
	private static final int MAX_NUM = 1000;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		final List<Future<Integer>> results = new ArrayList<>();
		
		final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
		
		for (int i=0; i < NUM_THREADS; i++) {
			final Future<Integer> futureObj = executorService.submit(
					() -> ThreadLocalRandom.current().nextInt(MAX_NUM));
			results.add(futureObj);
		}
		
		for (Future<Integer> result : results) {
			System.out.println(result.get());
		}

		executorService.shutdown();
	}	
}
