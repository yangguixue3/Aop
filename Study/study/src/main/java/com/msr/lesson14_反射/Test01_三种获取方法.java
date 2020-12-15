package com.msr.lesson14_反射;

/**
 * 三种获取方法
 */
public class Test01_三种获取方法 {

    public static void main(String[] args) {
        // 反射 :
        // 字节码文件 : .class
        // 字节码文件被加载到内存中后,就是 java.lang.Class 的对象
        // Class : 类的类型   :  类类型

        // 获取 Class
        // 1.Object 中 的  getClass()
        String str = "abc";

        Class<?> c1 = str.getClass();

        // 2.所有的类都有一个静态的隐藏的属性   :   .class
        Class c2 = String.class;

        // 3.Class 类 :  forName(全类名) ;

        try {
            Class c3 = Class.forName("java.lang.String");

            System.out.println(c1 == c2);
            System.out.println(c1 == c3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
