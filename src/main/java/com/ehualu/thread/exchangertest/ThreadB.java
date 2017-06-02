package com.ehualu.thread.exchangertest;

import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Administrator on 2017/6/2.
 */
public class ThreadB implements Runnable{
    private final Exchanger<Integer> exchanger;

    private AtomicReference<Integer> last = new AtomicReference<Integer>(10);


    public ThreadB(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        try{
            while (true) {
                last.set(exchanger.exchange(last.get()));
                System.out.println(" After calling exchange. Thread B has value: " + last.get());
                Thread.sleep(2000);
            }
        }catch(Exception ex){

        }
    }
}
