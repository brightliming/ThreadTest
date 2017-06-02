package com.ehualu.thread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/6/2.
 */
public class BankWaterService implements Runnable{

    private CyclicBarrier c = new CyclicBarrier(4,this);

    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String,Integer> sheetBankWaterBank = new ConcurrentHashMap<String, Integer>();

    private void count(){
        for(int i =0; i<4 ;i++ ){
            executor.execute(new Runnable() {
                public void run() {
                    sheetBankWaterBank.put(Thread.currentThread().getName(),1);
                    try {
                        c.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    int result = 0;
    public void run() {
        for(Map.Entry<String,Integer> entry:sheetBankWaterBank.entrySet()){
            result += entry.getValue();
        }

        System.out.println(result);
    }

    public static void main(String[] args){
        BankWaterService bankWaterService = new BankWaterService();

        bankWaterService.count();
    }
}
