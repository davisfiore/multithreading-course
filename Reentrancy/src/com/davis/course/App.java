package com.davis.course;

import java.util.concurrent.locks.ReentrantLock;

public class App {
	
	private final ReentrantLock lock = new ReentrantLock();

	
	public static void main(String[] args) {    	
		new App().call();    
	}

	public void call() {

		lock.lock();

		try {
			System.out.println("Called " + lock.getHoldCount() + " times");
			if (lock.getHoldCount() < 10) call();
		 } finally {
		        lock.unlock();
		 }		
	}
}