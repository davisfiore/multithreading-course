package com.davis.course;

public class Consumer implements Runnable {

	private final MessageBean message;
	
	public Consumer(MessageBean message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		
		try {
			synchronized (message) {
				if (message.get() == null)
					message.wait();
				System.out.println("Received message : " + message.get());
			}
		} catch (InterruptedException e) {e.printStackTrace();}
	}
}
