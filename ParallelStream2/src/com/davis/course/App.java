package com.davis.course;

import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {

    	IntStream.range(1, 25)
                .parallel() // try to comment this
                .forEach(n -> {
                    System.out.println("This is thread + " + Thread.currentThread().getName());
                });
    }
}