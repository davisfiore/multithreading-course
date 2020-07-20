package com.davis.course;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private final BlockingQueue<String> queue;
	
	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				final String message = queue.take();
				System.out.println("Received: " + message);
			}
		} catch (InterruptedException e) {e.printStackTrace();}
	}
}
