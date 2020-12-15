package com.msr.lesson10_线程共享Runnable的实现类的数据;


public class Test01 {


    public static void main(String[] args) {
        // 第一种方式 : 共用一个Runnable子类的对象，共享数据
        // 创建Runnable的子类对象
        MyThread myThread = new MyThread();
        // 创建线程
        Thread thread1 = new Thread(myThread,"郭靖....");
        thread1.start();

        Thread thread2 = new Thread(myThread,"郭靖222....");
        thread2.start();

        // 第二种方式 : 不共用一个Runnable子类的对象
//        MyThread myThread3 = new MyThread();
//        Thread thread3 = new Thread(myThread3,"黄蓉....");
//        thread3.start();
//        MyThread myThread4 = new MyThread();
//        Thread thread4 = new Thread(myThread4,"黄蓉444444....");
//        thread4.start();



    }
}
