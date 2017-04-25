package com.ehualu.thread;

import com.ehualu.util.SleepUtils;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * Created by Administrator on 2017/4/26.
 */
public class TwinsLockTest {
    @Test
    public void test(){
        final Lock lock = new TwinLock();
        class Worker extends Thread{
            public void run(){
                while(true){
                    lock.lock();
                    try{
                        SleepUtils.sleep(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.sleep(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
        for(int i=0;i<10;i++){
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }
        for(int i=0;i<10;i++){
            SleepUtils.sleep(1);
            System.out.println();
        }
    }
}
