package com.ny.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author nieyan
 * @create 2021-02-24 16:20
 **/
public class MyTest {
    @Test
    void name() {
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue();
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
        }
        linkedBlockingQueue.addAll(arrayList);

        MyConsumer m1 = new MyConsumer(linkedBlockingQueue);
        Thread t1 = new Thread(m1);
        MyConsumer m2 = new MyConsumer(linkedBlockingQueue);
        Thread t2 = new Thread(m2);
        MyConsumer m3 = new MyConsumer(linkedBlockingQueue);
        Thread t3 = new Thread(m2);

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    class MyConsumer implements Runnable {
        LinkedBlockingQueue<Integer> linkedBlockingQueue;

        public MyConsumer(LinkedBlockingQueue<Integer> linkedBlockingQueue) {
            this.linkedBlockingQueue = linkedBlockingQueue;
        }

        @Override
        public void run() {
            try {
                Integer take;
                while ((take = linkedBlockingQueue.take()) != null) {
                    System.out.println(Thread.currentThread().getName() + "==>" + take);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
