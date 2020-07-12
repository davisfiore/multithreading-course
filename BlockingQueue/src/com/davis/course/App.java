package com.davis.course;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

	public static void main(String[] args) {
		final BlockingQueue<String> queue = new LinkedBlockingQueue<>();

		final Runnable producer = new Producer(queue);
		Thread thread2 = new Thread(producer);

		final Runnable consumer = new Consumer(queue);
		Thread thread1 = new Thread(consumer);

		thread1.start();
		thread2.start();
	}
}