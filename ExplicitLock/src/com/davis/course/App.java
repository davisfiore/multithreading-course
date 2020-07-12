package com.davis.course;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

	private static final Lock lock = new ReentrantLock();
	private static int count = 0;
	
	public static void main(String[] args) throws InterruptedException {
		
		lock.lock();
	    
		try {
	        count++;
	        System.out.println("I'm the only thread that now can increase the counter");
	    } finally {
	        lock.unlock();
	        System.out.println("Now I released the lock");
	    }		
	}
}
