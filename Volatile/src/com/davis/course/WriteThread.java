package com.davis.course;

public class WriteThread extends Thread {
	@Override
    public void run() {

        while (true){
        	
        	App.counter++;
            
        	System.out.println("Incrementing to " + App.counter);
            
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) { 
            	e.printStackTrace(); 	
            }
        }
    }

}
