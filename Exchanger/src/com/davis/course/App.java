package com.davis.course;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	private static final Exchanger<String> exchanger = new Exchanger<>();
	
	public static void main(String[] args) {
		
		final ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 2; i++)
			executorService.submit(() -> {
				try {
					final String recv = exchanger.exchange(
						Thread.currentThread().getName());
					System.out.println(Thread.currentThread().getName() + 
							" has received a message from " + recv);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		
		executorService.shutdown();
	}	
}
