package com.davis.course;

public class Thread1 extends Thread {

	@Override
	public void run() {
		System.out.println("Running thread " + getName()
				+ " created by extending Thread");
	}
}
