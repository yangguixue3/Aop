package com.msr.lesson10_线程共享Runnable的实现类的数据;

import java.io.Serializable;


public class MyThread implements Runnable, Serializable {

    private int num = 5;


    @Override
    public void run() {
        // 数数 : 1~5
        try {
            for (int i = 0; i < num; num -- ) {
                System.out.println(Thread.currentThread().getName() + " = " + num);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
