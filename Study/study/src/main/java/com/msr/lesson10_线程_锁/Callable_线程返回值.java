package com.msr.lesson10_线程_锁;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  Callable 接口支持返回执行结果，此时需要调用 FutureTask.get()方法实现
 */
public class Callable_线程返回值 implements Callable {
    private String msg;
    @Override
    public String call() throws Exception {


        Thread.sleep(3000);
        msg = "我是call方法的返回值";
        return msg;
    }
}

class Test{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable_线程返回值 callable = new Callable_线程返回值();
        FutureTask<String> task = new FutureTask<>(callable);
        long startTime = System.currentTimeMillis();
        //创建线程
        new Thread(task).start();
        // 调用get()阻塞主线程，反之，线程不会阻塞
        String result = task.get();
        long endTime = System.currentTimeMillis();
        System.out.println("result = " + result);
        System.out.println("cast : " + (endTime - startTime) / 1000 + " second!");

    }
}