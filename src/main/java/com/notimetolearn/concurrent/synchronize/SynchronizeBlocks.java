package com.notimetolearn.concurrent.synchronize;

public class SynchronizeBlocks {

    private int counter = 0;
    private static int staticCounter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public static int getStaticCounter() {
        return staticCounter;
    }

    public static void setStaticCounter(int staticCounter) {
        SynchronizeBlocks.staticCounter = staticCounter;
    }

    public void syncMethodBlock() {
        synchronized (this){
            setCounter(getCounter()+1);
        }
    }

    public static void staticSyncMethodBlock() {
        synchronized (SynchronizeBlocks.class){
            setStaticCounter(getStaticCounter()+1);
        }
    }
}
