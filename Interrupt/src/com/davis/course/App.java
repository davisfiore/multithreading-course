package com.davis.course;

public class App {

	public static void main(String[] args) throws InterruptedException {

		final Thread thread1 = new MyThread();
		thread1.start();
		
		Thread.sleep(2000);
		
		thread1.interrupt();		
	}
}
