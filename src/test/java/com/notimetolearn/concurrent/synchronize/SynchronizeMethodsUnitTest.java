package com.notimetolearn.concurrent.synchronize;


import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizeMethodsUnitTest {

    @Test
    public void givenMultiThread_whenMethodNonSync() throws InterruptedException {
        SynchronizeMethods sm = new SynchronizeMethods();
        processExecution(sm::calculate);
        Assert.assertNotEquals(1000,sm.getSum());
    }

    @Test
    public void givenMultiThread_whenMethodSync() throws InterruptedException {
        SynchronizeMethods sm = new SynchronizeMethods();
        processExecution(sm::synchronisedCalculate);
        Assert.assertEquals(1000,sm.getSum());
    }

    @Test
    public void givenMultiThread_whenMethodSyncBlock() throws InterruptedException {
        SynchronizeBlocks sb = new SynchronizeBlocks();
        processExecution(sb::syncMethodBlock);
        Assert.assertEquals(1000,sb.getCounter());
    }

    @Test
    public void givenMultiThread_whenMethodStaticSync() throws InterruptedException {
        processExecution(SynchronizeMethods::syncStaticCalculate);
        Assert.assertEquals(1000,SynchronizeMethods.staticSum);
    }

    @Test
    public void givenMultiThread_whenStaticSyncBlock() throws InterruptedException {
        processExecution(SynchronizeBlocks::staticSyncMethodBlock);
        Assert.assertEquals(1000,SynchronizeBlocks.getStaticCounter());
    }

    private void processExecution(Runnable task) throws InterruptedException{
        ExecutorService service = Executors.newFixedThreadPool(3);
        IntStream.range(0,1000).forEach(count -> service.submit(task));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);
    }
}
