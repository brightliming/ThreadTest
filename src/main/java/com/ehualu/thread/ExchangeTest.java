package com.ehualu.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/2.
 */
public class ExchangeTest {
    private final static Exchanger<String> exgr = new Exchanger<String>();

    private static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args){
        executor.execute(new Runnable() {
            public void run() {
                String A = "银行流水A";
                try {
                    exgr.exchange(A);
                } catch (InterruptedException e) {

                }
            }
        });

        executor.execute(new Runnable() {
            public void run() {
                try {
                    String B = "银行流水B";
                    String A = exgr.exchange("B");
                    System.out.println("A和B数据是否一致："+A.equals(B)+", A录入的是："+A+", B录入的是："+B);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executor.shutdown();
    }
}
