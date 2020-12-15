package com.msr.lesson09_线程实现Runnable;


public class TestThread {

    public static void main(String[] args) {

        // 创建线程
        MyThread myThread = new MyThread();

        myThread.setName("郭靖~~~~~~~~~~~~");

        // 启动线程
        myThread.start();

        MyThread myThread1 = new MyThread();
        myThread1.setName("黄蓉 ^_^");
        myThread1.start();
    }
}
