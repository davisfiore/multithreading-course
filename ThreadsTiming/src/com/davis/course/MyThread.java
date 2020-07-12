package com.davis.course;

public class MyThread extends Thread {

	private final int id;
	
	public MyThread(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Running thread " + id);
	}
}
