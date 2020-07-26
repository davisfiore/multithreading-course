package com.davis.course;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StringContainer {

	private final Queue<String> values = new LinkedList<>();
	private final int maxSize;
	private final Lock lock = new ReentrantLock();
	
	// Condition predicate: non full (size < maxSize)
	private final Condition nonFull = lock.newCondition();

	// Condition predicate: non empty (size > 0)
	private final Condition nonEmpty = lock.newCondition();

	public StringContainer(final int maxSize) {
		this.maxSize = maxSize;
	}
	
	public void add(final String str) throws InterruptedException {
		
		lock.lock();

		try {
			while (isFull()) {
				nonFull.await();
			}

			values.add(str);
			
			System.out.println("Store string : " + str);
 
			nonEmpty.signal();

		} finally {
			lock.unlock();
		}
	}

	public void remove() throws InterruptedException {

		lock.lock();

		try {
			while (isEmpty()) {
				nonEmpty.await();
			}

			System.out.println("Removing " + values.remove());

			nonFull.signal();
			
		} finally {
			lock.unlock();
		}
	}
	
	private boolean isFull() {
		return values.size() >= maxSize;
	}
	
	private boolean isEmpty() {
		return values.isEmpty();
	}	
}