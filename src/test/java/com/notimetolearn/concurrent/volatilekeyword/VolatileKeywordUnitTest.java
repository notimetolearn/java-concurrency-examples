package com.notimetolearn.concurrent.volatilekeyword;

import org.junit.Assert;
import org.junit.Test;

public class VolatileKeywordUnitTest {

    @Test
    public void whenOneThreadWrites_ThenVolatileReadsFromMainMemory() throws InterruptedException {

        SharedObject so = new SharedObject();

        Thread writer = new Thread(()-> so.incrementCount());
        writer.start();
        //Thread.sleep(100);

        Thread readerOne = new Thread(()->
            {
                int valueReadByThread2 = so.getCount();
                Assert.assertEquals(1,valueReadByThread2);
            }
        );

        readerOne.start();
        Thread readerTwo = new Thread(()->
        {
            int valueReadByThread3 = so.getCount();
            Assert.assertEquals(1,valueReadByThread3);
        }
        );

        readerTwo.start();
    }

    @Test
    public void whenTwoThreadWrites_ThenVolatileReadsFromMainMemory() throws InterruptedException {

        SharedObject so = new SharedObject();

        Thread writerOne = new Thread(()-> so.incrementCount());
        writerOne.start();
        Thread.sleep(100);

        Thread writerTwo = new Thread(()-> so.incrementCount());
        writerTwo.start();
        Thread.sleep(100);

        Thread readerOne = new Thread(()->
        {
            int valueReadByThread3 = so.getCount();
            Assert.assertEquals(2,valueReadByThread3);
        }
        );

        readerOne.start();
        Thread readerTwo = new Thread(()->
        {
            int valueReadByThread4 = so.getCount();
            Assert.assertEquals(2,valueReadByThread4);
        }
        );

        readerTwo.start();
    }
}
