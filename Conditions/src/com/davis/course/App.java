package com.davis.course;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	public static void main(String[] args) {

		final StringContainer container = new StringContainer();		
		final ExecutorService es = Executors.newFixedThreadPool(2);

		es.submit(() -> {
				try {
					container.put("First");
					container.put("Second");
					container.put("Third");
				} catch (InterruptedException e) {e.printStackTrace();}
			}    		
		);
		
		es.submit(() -> {
				try {
					container.take();
					container.take();
					container.take();		
				} catch (InterruptedException e) {e.printStackTrace();}
			}    		
		);
	}
}
