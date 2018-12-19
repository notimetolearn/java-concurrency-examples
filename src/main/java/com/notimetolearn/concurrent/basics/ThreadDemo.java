package com.notimetolearn.concurrent.basics;


class SingleThread extends Thread{
    public void run(){
        for(int i=0; i < 10; i++){
            System.out.println("Running Single Thread: "+i+this.getName());
        }
    }
}

class Runner implements Runnable{
    public void run(){
        for(int i=0; i < 10; i++){
            System.out.println("Running Runnable: "+i);
        }
    }
}

public class ThreadDemo {

    public static void main(String... args){

        //extending Thread
        SingleThread t1 = new SingleThread();
        t1.start();

        //using an interface
        Thread t2 = new Thread(new Runner());
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 10; i++){
                    System.out.println("From Anonymous: "+i);
                }
            }
        });

        t3.start();

        //using lamdas
        Thread t4 = new Thread(()-> {
            for(int i=0; i < 10; i++){
                System.out.println("From a Lamda: "+i);
            }
        });

        t4.start();
    }
}
