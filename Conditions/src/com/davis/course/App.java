package com.davis.course;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	private static final int BUFFER_SIZE = 3;
	private static final int NUM_THREADS = 2;
	
	public static void main(String[] args) {

		final StringQueue queue = new StringQueue(BUFFER_SIZE);		
		final ExecutorService es = Executors.newFixedThreadPool(NUM_THREADS);

		es.submit(() -> {
			try {
				for(int i = 1; i < 10; i++) {
						queue.add(String.valueOf(i));
				}
			} catch (InterruptedException e) {e.printStackTrace();}				
		});
		
		es.submit(() -> {
			try {
				for(int i = 1; i < 10; i++) {
					queue.remove();
				}	
			} catch (InterruptedException e) {e.printStackTrace();}				
		});
	}
}
