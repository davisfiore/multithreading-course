package com.davis.course;

public class Thread1 extends Thread {

	private final Object obj1;
	private final Object obj2;
	
	public Thread1(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		
		synchronized(obj1) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread1 acquired first lock");
			synchronized(obj2) {
				System.out.println("Thread1 acquired second lock");				
			}			
		}
	}
}
