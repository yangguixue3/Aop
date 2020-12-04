package com.msr.studyProxy2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 *      *  装饰类提前写好；
 *      * 动态代理特点:
 *      *     分类:
 *      *
 *      *          2.基于类的 类代理 Enhancer.creat 三方
 *                  依赖 cjlib
 *                  public static Object create(Class type, Callback callback)

 */
public class Client {
    public static void main(String[] args) {
        // 假设零售价10000
        Double price1 = 10000D;
        // 假设售后服务100
        Double price2 = 1000D;

        Producer producer = new Producer();

        Producer producerProxy = (Producer) Enhancer.create(producer.getClass(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Double money = (Double) objects[0];//获取设置的参数
                Object value = method.invoke(producer,money*0.9);
                return value;
            }
        });
        System.out.println(String.format("零售价%s",price1));
        producerProxy.saleProduct(price1);
        System.out.println("---------------------------");
        System.out.println(String.format("假设售后服务%s",price2));
        producerProxy.afterService(price2);
    }
}
