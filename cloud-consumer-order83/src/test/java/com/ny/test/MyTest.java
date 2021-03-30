package com.ny.test;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author nieyan
 * @create 2021-03-26 11:11
 **/
public class MyTest {
    @Test
    public void name() {
        FutureTask<String> futureTask = new FutureTask<String>(()->{
            TimeUnit.SECONDS.sleep(5);
            return "hello";
        });

        new Thread(futureTask,"t1").start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
