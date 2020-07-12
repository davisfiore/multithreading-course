package com.davis.course;

public class Producer implements Runnable {

	private final MessageBean message;
	
	public Producer(MessageBean message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		
		try {
			synchronized (message) {
				Thread.sleep(2000);
				message.set("Produced something!");
				message.notify();
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
