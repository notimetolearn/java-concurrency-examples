package com.notimetolearn.concurrent.basics;

class Counter {

    private int c = 0;

    public void increment(){
        c++;
    }

    public void decrement(){
        c--;
    }

    public int value(){
        return c;
    }
}

public class ThreadInterference {

    public static void main(String... args){
        Counter c = new Counter();
        Thread t1 = new Thread(()-> {
           for(int i=0; i< 10000;i++){
               c.increment();
           }
        });

        Thread t2 = new Thread(()-> {
            for(int i=0; i< 10000;i++){
                c.decrement();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(c.value());
    }
}