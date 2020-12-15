package com.msr.lesson09_线程实现Runnable;


public class MyThread extends Thread {

    @Override
    public void run() {
        // 数数 : 1~5
        for (int i = 0; i < 5; i++) {
            // 获取当前线程
            Thread thread = Thread.currentThread();
            // 获取线程名称
            String name = thread.getName();
            System.out.println(name + " = " + i);
        }
    }
}
