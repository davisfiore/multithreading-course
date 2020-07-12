package com.davis.course;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StringContainer {

	private boolean isFull;
	private String value;
	
	private final Lock lock = new ReentrantLock();
	
	private final Condition full = lock.newCondition();
	private final Condition empty = lock.newCondition();

	public void put(String str) throws InterruptedException {
		lock.lock();

		try {
			while (isFull) {
				empty.await();
			}

			value = str;
			
			System.out.println("Store string : " + value);

			isFull = true;
 
			full.signal();

		} finally {
			lock.unlock();
		}
	}

	public String take() throws InterruptedException {
		lock.lock();

		try {
			while (!isFull) {
				full.await();
			}

			System.out.println("Emptying container");
 
			isFull = false;
			
			empty.signal();
			
		} finally {
			lock.unlock();
		}
		
		return value;
	}
}