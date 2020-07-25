package com.davis.course;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StringContainer {

	private String value;	
	private final Lock lock = new ReentrantLock();
	private final Condition full = lock.newCondition();
	private final Condition empty = lock.newCondition();

	public void put(String str) throws InterruptedException {
		
		lock.lock();

		try {
			while (isFull()) {
				empty.await();
			}

			value = str;
			
			System.out.println("Store string : " + value);
 
			full.signal();

		} finally {
			lock.unlock();
		}
	}

	public String take() throws InterruptedException {
		
		lock.lock();

		try {
			while (!isFull()) {
				full.await();
			}

			value = "";
			
			System.out.println("Emptying container");
 			
			empty.signal();
			
		} finally {
			lock.unlock();
		}
		
		return value;
	}
	
	private boolean isFull() {
		return value != null && !value.equals("");
	}
}