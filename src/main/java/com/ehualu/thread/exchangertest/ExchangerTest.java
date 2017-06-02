package com.ehualu.thread.exchangertest;

import java.util.concurrent.Exchanger;

/**
 * Created by Administrator on 2017/6/2.
 */
public class ExchangerTest {
    public static void main(String[] args){
        Exchanger<Integer> exchanger = new Exchanger<Integer>();

        new Thread(new ThreadA(exchanger)).start();
        new Thread(new ThreadB(exchanger)).start();

    }
}
