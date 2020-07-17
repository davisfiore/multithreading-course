package com.davis.course;

public class App {

	public static void main(String[] args) {

		final Counter counter = new Counter();
		
		for (int i = 0; i < 100; i++) {
			final Thread thread = new MyThread(counter);
			thread.start();
		}	
	}
}
