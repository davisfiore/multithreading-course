package com.davis.course;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private final BlockingQueue<String> queue;
	
	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		
		try {
			while(true) {
				Thread.sleep(2000);
				queue.put("Time in ms is " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
