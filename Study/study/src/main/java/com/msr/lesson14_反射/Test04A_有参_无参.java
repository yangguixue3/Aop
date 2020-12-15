package com.msr.lesson14_反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 */
public class Test04A_有参_无参 {
    public static void main(String[] args) {
        // 不创建A类的对象来调用A的函数
        // 1.获取类类型
        Class c = A.class ;
        // 2.获取函数
        try {
            Method m1 = c.getMethod("m1");
            // 创建A类的对象
            Object o = c.newInstance();
            // 调用函数
            Object invoke = m1.invoke(o);
            System.out.println("invoke = " + invoke);

            // 有参无返回值
            Method m2 = c.getMethod("m1", int.class);
            Object invoke1 = m2.invoke(c.newInstance(), 9527);
            System.out.println("invoke1 = " + invoke1);

            // 有参有返回值
            Method m3 = c.getMethod("m1", int.class, String.class);
            Object javaEe = m3.invoke(c.newInstance(), 3306, "javaEe");
            System.out.println("javaEe = " + javaEe);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
