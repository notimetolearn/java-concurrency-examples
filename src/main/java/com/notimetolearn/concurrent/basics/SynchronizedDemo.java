package com.notimetolearn.concurrent.basics;

class SynchronizedCounter {

    private int counter = 0;

    public synchronized void increment(){
        System.out.println(Thread.currentThread().getName()+": incrementing");
        counter++;
    }

    public synchronized void decrement(){
        System.out.println(Thread.currentThread().getName()+": decrementing");
        counter--;
    }

    public int value(){
        return counter;
    }
}

public class SynchronizedDemo {

    public static void main(String... args){

        SynchronizedCounter sc = new SynchronizedCounter();
        Thread t1 = new Thread(()-> {
            for(int i=0; i< 10000;i++){
                sc.increment();
            }
        });

        Thread t2 = new Thread(()-> {
            for(int i=0; i< 10000;i++){
                sc.decrement();
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
        System.out.println(sc.value());
    }
}
