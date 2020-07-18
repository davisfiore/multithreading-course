package com.davis.course;

public class MyThread extends Thread {

	private final Counter counter;
	
	public MyThread(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {  //Fix this!!!
		
		while (true ) {
			counter.increment();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {e.printStackTrace();}
			
			counter.decrement();
			
			System.out.println("Count = " + counter.get());
		}
	}	
}
