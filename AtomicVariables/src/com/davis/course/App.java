package com.davis.course;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class App {

    public static void main(String[] args) {

    	final AtomicInteger atomicInt = new AtomicInteger(0);
 
    	System.out.println("Increment: " + atomicInt.incrementAndGet());
    	System.out.println("Add: " + atomicInt.addAndGet(10));

    	final AtomicReference<String> atomicReference = new AtomicReference<>("boss");

    	boolean changed = atomicReference.compareAndSet("boss", "Boss");
    	System.out.println("Reference exchanged: " + changed);
    }
}