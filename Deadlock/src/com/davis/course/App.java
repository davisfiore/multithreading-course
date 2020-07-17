package com.davis.course;

public class App {

	public static void main(String[] args) {

		final Object obj1 = new Object();
		final Object obj2 = new Object();
		
		final Thread thread1 = new Thread1(obj1, obj2);
		thread1.start();

		final Thread thread2 = new Thread2(obj1, obj2);
		thread2.start();
	}
}
