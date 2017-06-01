package com.ehualu.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2017/6/1.
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2,new A());

    public static void main(String[] args){
        new Thread(new Runnable() {
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
                System.out.println(2);
            }
        }).start();

        try{
            c.await();
        }catch(Exception e){

        }
        System.out.println(1);
    }

    static class A implements Runnable{

        public void run() {
            System.out.println("3");
        }
    }
}
