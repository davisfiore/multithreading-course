package com.davis.course;

public class ReadThread extends Thread {

    @Override
    public void run() {
        
    	int lastValue = App.counter;
        
    	while (true){
          	
            if( lastValue!= App.counter){
                System.out.println("Got Change: " + App.counter);
                lastValue = App.counter;
            }
        }
    }
}
