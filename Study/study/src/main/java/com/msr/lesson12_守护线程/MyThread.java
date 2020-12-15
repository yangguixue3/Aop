package com.msr.lesson12_守护线程;

import java.io.Serializable;


public class MyThread implements Runnable, Serializable {

    @Override
    public void run() {
        while (true) {
            System.out.println("********守护进程********");
        }
    }

}
