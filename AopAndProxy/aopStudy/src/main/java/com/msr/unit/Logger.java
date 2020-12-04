package com.msr.unit;


public class Logger {

    /**
     * 用于打印日志:
     *      计划在切入点方法(也就是业务层的增 删 改 ) 执行之前执行 log 日志 :
     */
    public void printLog(){
        System.out.println("开始打印日志了........");
    }

}
