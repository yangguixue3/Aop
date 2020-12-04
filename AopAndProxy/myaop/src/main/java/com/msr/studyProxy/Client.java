package com.msr.studyProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *      *  装饰类提前写好；
 *      * 动态代理特点:
 *      *     分类:
 *      *          1.基于JDK的 接口代理
 *      *          2.基于子类的 类代理
 *      *      涉及到JDK的proxy public static Object newProxyInstance(ClassLoader loader,  类加载器
 *                                           Class<?>[] interfaces,  接口
 *                                           InvocationHandler h)  增强功能
 *      *
 *      *      步骤:1.建接口
 *      *          2.被代理的对象实现接口
 *      *          3.被代理的对象实现接口
 */
public class Client {
    public static void main(String[] args) {
        // 假设零售价10000
        Double price1 = 10000D;
        // 假设售后服务100
        Double price2 = 100D;



        Producer producer = new Producer();

        ProducerInterface producerInterface  = (ProducerInterface) Proxy.newProxyInstance(
                producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // Object[] args参数
                        System.out.println("代理商提成毛利的10%");
                        Double money = (Double) args[0];//获取设置的参数
                        Object value = method.invoke(producer,money*0.9);
                        return value;
                    }
                }
        );
        System.out.println(String.format("零售价%s",price1));
        producerInterface.saleProduct(price1);
        System.out.println("---------------------------");
        System.out.println(String.format("假设售后服务%s",price2));
        producerInterface.afterService(price2);
    }
}
