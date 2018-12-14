package com.notimetolearn.concurrent.basics;

public class SingleThread extends Thread {

    @Override
    public void run() {
        int i = 0;
        while(true){
            System.out.println(this.getName()+ ":New thread is running..."+i++);
            try {
                //wait one second to print the message in between
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
