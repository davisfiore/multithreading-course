package com.davis.course;

public class App {
	
	static volatile int counter = 0;
	//static int counter = 0;

    public static void main(String[] args) {
    
        new ReadThread().start();
    	new WriteThread().start();
    }
}