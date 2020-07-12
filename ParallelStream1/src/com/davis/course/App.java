package com.davis.course;

import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {
    	
       System.out.println("Printing with conventional stream:");
       IntStream.range(1, 10).forEach(System.out::println);

       System.out.println("Printing with parallel stream:");
       IntStream.range(1, 10).parallel().forEach(System.out::println);    	
    }
}