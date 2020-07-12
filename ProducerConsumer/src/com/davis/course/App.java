package com.davis.course;

public class App {

	public static void main(String[] args) {
		final MessageBean message = new MessageBean();

		final Runnable producer = new Producer(message);
		final Thread thread2 = new Thread(producer);

		final Runnable consumer = new Consumer(message);
		final Thread thread1 = new Thread(consumer);

		thread1.start();
		thread2.start();
	}
}