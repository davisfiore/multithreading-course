package com.davis.course;

public class Counter {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int get() {
        return count;
    }
}