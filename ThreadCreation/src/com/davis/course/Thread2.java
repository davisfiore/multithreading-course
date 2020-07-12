package com.davis.course;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Running thread " + Thread.currentThread().getName()
				+ " created by implementing Runnable");
	}
}
