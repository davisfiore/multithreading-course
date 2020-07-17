package com.davis.course;

public class App {

	public static void main(String[] args) {

		// Thread created by extending the class Thread
		final Thread thread1 = new Thread1();
		thread1.start();

		// Thread created by implementing the interface Runnable
		final Runnable runnable = new Thread2();
		final Thread thread2 = new Thread(runnable);
		thread2.start();
	}
}
