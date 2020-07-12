package com.davis.course;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class App {
	
	private static final Phaser phaser = new Phaser();
	
	public static void main(String[] args) {
		
		final ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 3; i++)
			executorService.submit(() -> {
				
				phaser.register();
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {e.printStackTrace();}
				
				for (int phase = 1; phase <= 5; phase++) {
					phaser.arriveAndAwaitAdvance();
					
					System.out.println("Thread " +
						Thread.currentThread().getName() 
						+ " advanced (phase " + phase + ")");
				}
				
				phaser.arriveAndDeregister();
				System.out.println("Thread " + Thread.currentThread().getName() 
					+ " Deregistered");
			});
		
		executorService.shutdown();
	}	
}
