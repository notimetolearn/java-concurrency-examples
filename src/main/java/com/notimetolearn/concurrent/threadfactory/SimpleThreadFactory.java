package com.notimetolearn.concurrent.threadfactory;

import java.util.concurrent.ThreadFactory;

public class SimpleThreadFactory implements ThreadFactory {

    private int threadId;
    private String threadName;

    public SimpleThreadFactory(String threadName){
        this.threadId = 1;
        this.threadName = threadName;
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,threadName+"-Thread_"+threadId);
        System.out.println("Created new thread with name: "+t.getName()+" and id:"+threadId);
        threadId++;
        return t;
    }
}
