package com.davis.course;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StringContainer {

	private String value;	
	private final Lock lock = new ReentrantLock();
	private final Condition full = lock.newCondition();
	private final Condition empty = lock.newCondition();

	public void add(String str) throws InterruptedException {
		
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

	public void remove() throws InterruptedException {

		lock.lock();

		try {
			while (!isFull()) {
				full.await();
			}
			
			System.out.println("Removing " + value);

			value = "";

			empty.signal();
			
		} finally {
			lock.unlock();
		}
	}
	
	private boolean isFull() {
		return value != null && !value.equals("");
	}
}