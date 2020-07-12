package com.davis.course;

public class MyThread extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exiting thread...");
	}
}
