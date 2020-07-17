package com.davis.course;

public class App {

	public static void main(String[] args) throws InterruptedException {

		final Thread thread1 = new MyThread();
		thread1.start();
		
		thread1.join();
		
		System.out.println("Exited thread 1");
		
		
	}
}
