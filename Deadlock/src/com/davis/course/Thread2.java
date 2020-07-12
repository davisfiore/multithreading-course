package com.davis.course;

public class Thread2 extends Thread {

	private final Object obj1;
	private final Object obj2;
	
	public Thread2(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		
		synchronized(obj2) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread2 acquired first lock");
			synchronized(obj1) {
				System.out.println("Thread2 acquired second lock");				
			}			
		}
	}
}