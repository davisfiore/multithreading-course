package com.davis.course;

public class MyThread extends Thread {

	private final Counter counter;
	
	public MyThread(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				synchronized(counter) {
					counter.increment();
					Thread.sleep(100);
					counter.decrement();
				}
				System.out.println("Count = " + counter.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}
