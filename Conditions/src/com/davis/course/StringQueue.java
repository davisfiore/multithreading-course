package com.davis.course;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StringQueue {

	private final Queue<String> queue = new LinkedList<>();
	private final int maxSize;
	private final Lock lock = new ReentrantLock();
	
	// Condition predicate: non full (size < maxSize)
	private final Condition nonFull = lock.newCondition();

	// Condition predicate: non empty (size > 0)
	private final Condition nonEmpty = lock.newCondition();

	public StringQueue(final int maxSize) {
		this.maxSize = maxSize;
	}
	
	public void add(final String str) throws InterruptedException {
		
		lock.lock();

		try {
			while (isFull()) {
				nonFull.await();
			}

			queue.add(str);
			
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

			System.out.println("Removing " + queue.remove());

			nonFull.signal();
			
		} finally {
			lock.unlock();
		}
	}
	
	private boolean isFull() {
		return queue.size() >= maxSize;
	}
	
	private boolean isEmpty() {
		return queue.isEmpty();
	}	
}