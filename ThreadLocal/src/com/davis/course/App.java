package com.davis.course;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	private static final SafeCalendar calendar = new SafeCalendar();
	
	public static void main(String[] args) {
		
		final ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.submit(() -> System.out.println(System.identityHashCode(calendar.getCalendar())));
		executorService.submit(() -> System.out.println(System.identityHashCode(calendar.getCalendar())));
		
		executorService.shutdown();
	}	
}
