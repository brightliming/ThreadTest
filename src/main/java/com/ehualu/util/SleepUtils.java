package com.ehualu.util;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/26.
 */
public class SleepUtils {
    public static void sleep(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
