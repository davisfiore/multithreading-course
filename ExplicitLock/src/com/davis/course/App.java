package com.davis.course;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

	private final Lock lock = new ReentrantLock();
	private int count;
	
	public static void main(String[] args) {
		new App().increment();
	}
	
	public void increment() {
		
		lock.lock();
	    
		try {
	        System.out.println("I'm the only thread that now can increase the counter to " + ++count);
	    } finally {
	        lock.unlock();
	        System.out.println("Now I released the lock");
	    }		
	}
}
