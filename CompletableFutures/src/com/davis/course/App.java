package com.davis.course;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		runATask();
		runATaskAndReturnAValue();
		runATaskAndCompleteTheTheExecutionManually();	
		runATaskWithCallback();
		runATaskAndchainedCallbacks();
		runATaskWithAsynchCallback();
		useThenCompose();
		useThenCombine();
	}	
	
	private static void runATask() {
		
		CompletableFuture.runAsync(() -> System.out.println("Hello!"));		
	}

	private static void runATaskAndReturnAValue() throws InterruptedException, ExecutionException {
		
		CompletableFuture<Integer> future = 
				CompletableFuture.supplyAsync(() -> 5);	
		
		System.out.println(future.get());
	}

	private static void runATaskAndCompleteTheTheExecutionManually() throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			
			return "Message never returned";
		});	
		
		future.complete("Thread manually completed!");
		
		System.out.println(future.get());		
	}

	private static void runATaskWithCallback() throws InterruptedException, ExecutionException {
		
		CompletableFuture.supplyAsync(() -> 123)
			.thenAccept(System.out::println);		
	}

	private static void runATaskAndchainedCallbacks() throws InterruptedException, ExecutionException {
		
		CompletableFuture.supplyAsync(() -> "AB")
			.thenApply(l -> l + "CD")
			.thenAccept(System.out::println)
			.thenRun(() -> System.out.println("End of the chain"));		
	}
	
	private static void runATaskWithAsynchCallback() throws InterruptedException, ExecutionException {
		
		CompletableFuture.runAsync(() -> System.out.println("One"))
			.thenRunAsync(() -> System.out.println("Two"));		
	}
	
	private static void useThenCompose() throws InterruptedException, ExecutionException {
		
		CompletableFuture.supplyAsync(() -> 4)
			.thenCompose(n -> CompletableFuture.runAsync(() -> System.out.println(n + 2)));		
	}
	
	private static void useThenCombine() throws InterruptedException, ExecutionException {
		
		CompletableFuture.supplyAsync(() -> 3)
			.thenCombine(CompletableFuture.supplyAsync(() -> 4), (a,b) -> a + b)
			.thenAccept(System.out::println);
	}
}
