package com.davis.course;

public class Producer implements Runnable {

	private final MessageBean message;
	
	public Producer(MessageBean message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
			synchronized (message) {
				message.set("Produced something!");
				message.notify();
			}
		} catch (InterruptedException e) {e.printStackTrace();}
	}
}
