package com.notimetolearn.concurrent.basics;

import java.util.Arrays;
import java.util.List;


public class SleepMessagesDemo{

    static void threadMessage(String message){
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    private static class MessageLoop implements Runnable{

        public void run(){
            List<String> messages = Arrays.asList("Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too");

            for(String message: messages){
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    threadMessage("I wasn't done yet");
                }
                threadMessage(message);
            }
        }
    }

    public static void main(String... args) throws InterruptedException{

        //16 seconds
        long patience = 8000;

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        while(t.isAlive()){
            threadMessage("Still waiting...");
            t.join(1000);
            if((System.currentTimeMillis()-startTime) > patience && t.isAlive()){
                threadMessage("Tired of waiting!");
                t.interrupt();
                t.join();
            }
        }

        threadMessage("Finished finally");
    }
}
