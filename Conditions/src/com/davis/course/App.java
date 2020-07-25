package com.davis.course;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	public static void main(String[] args) {

		final StringContainer container = new StringContainer(3);		
		final ExecutorService es = Executors.newFixedThreadPool(2);

		es.submit(() -> {
			try {
				for(int i = 1; i < 10; i++) {
						container.add(String.valueOf(i));
				}
			} catch (InterruptedException e) {e.printStackTrace();}				
		});
		
		es.submit(() -> {
			try {
				for(int i = 1; i < 10; i++) {
					container.remove();
				}	
			} catch (InterruptedException e) {e.printStackTrace();}				
		});
	}
}
