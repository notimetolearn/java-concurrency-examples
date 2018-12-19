package com.notimetolearn.concurrent.basics;

import java.util.Arrays;
import java.util.List;

public class SleepMessagesDemo{

    public static void main(String... args) throws InterruptedException {
        List<String> messages = Arrays.asList("Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too");

        for(String message: messages){
            Thread.sleep(4000);
            System.out.println(message);
        }
    }
}
