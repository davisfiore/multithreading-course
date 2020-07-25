package com.davis.course;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StringContainer {

	private final Queue<String> values = new LinkedList<>();
	private final int size;
	private final Lock lock = new ReentrantLock();
	private final Condition full = lock.newCondition();
	private final Condition empty = lock.newCondition();

	public StringContainer(int size) {
		this.size = size;
	}
	
	public void add(String str) throws InterruptedException {
		
		lock.lock();

		try {
			while (isFull()) {
				full.await();
			}

			values.add(str);
			
			System.out.println("Store string : " + str);
 
			empty.signal();

		} finally {
			lock.unlock();
		}
	}

	public void remove() throws InterruptedException {

		lock.lock();

		try {
			while (isEmpty()) {
				empty.await();
			}

			System.out.println("Removing " + values.remove());

			full.signal();
			
		} finally {
			lock.unlock();
		}
	}
	
	private boolean isFull() {
		return values.size() >= size;
	}
	
	private boolean isEmpty() {
		return values.isEmpty();
	}	
}