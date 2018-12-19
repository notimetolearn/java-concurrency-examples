package com.notimetolearn.concurrent.volatilekeyword;

public class SharedObject {

    private volatile int count = 0;

    public int getCount() {
        return count;
    }

    public void incrementCount(){
        count++;
    }
}
