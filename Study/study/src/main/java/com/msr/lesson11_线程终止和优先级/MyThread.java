package com.msr.lesson11_线程终止和优先级;

import java.io.Serializable;


public class MyThread implements Runnable, Serializable {
    /**
     * flag 控制线程结束，有2种方法，这是一种，还有一种是，调用 interrupt()
     */
    private boolean flag = true ;

    @Override
    public void run() {
        // 数数 : 1~40
        for (int i = 0; flag ; ++ i ) {
            System.out.println(Thread.currentThread().getName() + " = " + i + " : 优先级 : " + Thread.currentThread().getPriority());
        }
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
