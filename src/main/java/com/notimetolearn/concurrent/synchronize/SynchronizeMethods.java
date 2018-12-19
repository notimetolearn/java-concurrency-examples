package com.notimetolearn.concurrent.synchronize;

public class SynchronizeMethods {

    private int sum = 0;
    static int staticSum = 0;

    public void calculate(){
        setSum(getSum() + 1);
    }

    public synchronized void synchronisedCalculate(){
        setSum(getSum() + 1);
    }

    public static synchronized void syncStaticCalculate(){
        staticSum = staticSum + 1;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
