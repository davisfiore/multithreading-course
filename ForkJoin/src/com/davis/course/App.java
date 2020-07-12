package com.davis.course;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class App
{
	public static void main(String[] args) {
		
		final Integer[] numbers = Stream.generate(() -> new Random().nextInt(10))
        .limit(100)
        .toArray(Integer[]::new);
		
		final int availProcs = Runtime.getRuntime().availableProcessors();
		
		final ForkJoinPool pool = new ForkJoinPool(availProcs);
		final int sum = pool.invoke(new SumCalculator(numbers));
     
		System.out.printf("The sum is " + sum);
	}
}