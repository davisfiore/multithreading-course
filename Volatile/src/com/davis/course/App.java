package com.davis.course;

public class App {
	
	static volatile int counter;
	//static int counter;

    public static void main(String[] args) {
    
        new ReadThread().start();
    	new WriteThread().start();
    }
}