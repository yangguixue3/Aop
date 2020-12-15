package com.msr.lesson13_主线程中加入一个线程;

/**
 * join
 */
public class Test02 {


    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        // 创建线程
        Thread thread1 = new Thread(myThread,"郭靖....");
        thread1.start();

        try {
            for (int i = 0; i < 10; i++) {
                if (i == 2)
                    thread1.join();//主线程中加入 别的线程
                System.out.println(Thread.currentThread().getName() + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
