package com.msr.lesson13_主线程中加入一个线程;

import java.io.Serializable;


public class MyThread implements Runnable, Serializable {

    @Override
    public void run() {
        // 数数 : 1~40
        for (int i = 0; i < 40 ; ++ i ) {
            System.out.println(Thread.currentThread().getName() + " = " + i + " : 优先级 : " + Thread.currentThread().getPriority());
        }
    }

}
