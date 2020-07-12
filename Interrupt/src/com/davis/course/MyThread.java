package com.davis.course;

public class MyThread extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted!");
			return;
		}
	}
}
