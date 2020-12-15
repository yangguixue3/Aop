package com.msr.lesson12_守护线程;

/**
 * 主要线程运行的时候，你还想让一个不太重要的线程执行任务，但是又想等主要线程退出时不太重要的线程也立刻结束
 * 如果将不太重要的线程设置为守护进程
 * 中断线程也可以
 */
public class Test01 {


    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        // 创建线程
        Thread thread1 = new Thread(myThread,"守护....");
        // 用户线程
        // 守护线程
        thread1.setDaemon(true);
        thread1.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(2);
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
