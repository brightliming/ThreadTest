package com.ehualu.thread.exchangertest;

import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Administrator on 2017/6/2.
 */
public class ThreadA implements Runnable{
    private final Exchanger<Integer> exchanger;

    private AtomicReference<Integer> last = new AtomicReference<Integer>(5);


    public ThreadA(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        try{
            while (true) {
                last.set(exchanger.exchange(last.get()));
                System.out.println(" After calling exchange. Thread A has value: " + last.get());
                Thread.sleep(2000);
            }
        }catch(Exception ex){

        }

    }
}
