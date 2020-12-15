package com.msr.lesson11_线程终止和优先级;


public class Test01 {


    public static void main(String[] args) {
        // 创建Runnable的子类对象
        MyThread myThread = new MyThread();
        // 创建线程
        Thread thread1 = new Thread(myThread,"郭靖....");//
        thread1.setPriority(1);
        thread1.start();// 就绪状态 :


        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread.setFlag(false);//终止线程

//         Thread thread2 = new Thread(myThread,"黄蓉 ^_^      ~~~~~~~");
//         thread2.setPriority(10);
//         thread2.start();

    }
}
