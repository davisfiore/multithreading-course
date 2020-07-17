package com.davis.course;

public class App {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++ ) {
			final Thread thread1 = new MyThread(i);
			thread1.start();
		}
	}
}
