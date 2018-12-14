package com.notimetolearn.concurrent.threadfactory;

public class ThreadFactoryDemo {

    public static void main(String... args){
        SimpleThreadFactory stf = new SimpleThreadFactory("SimpleThreadFactory");

        for (int i = 0; i < 10; i++) {
            Thread t = stf.newThread(new Task());
            t.start();
        }
    }
}
