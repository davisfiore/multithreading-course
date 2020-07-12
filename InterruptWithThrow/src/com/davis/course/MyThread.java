package com.davis.course;

public class MyThread extends Thread {

	@Override
	public void run() {
		try {
			doNothing();
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted!");
			return;
		}
	}
	
	private void doNothing() throws InterruptedException {
		
		while(true) {
			Thread.yield();
			if (Thread.interrupted()) throw new InterruptedException();
		}
	}
}
