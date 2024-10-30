package com.example.testservice.demo;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
 
        try {
            Thread.sleep(3000);            
        } catch (Exception e) {
        }

        System.err.println("async task done : "+Thread.currentThread());
        
    }

    
}