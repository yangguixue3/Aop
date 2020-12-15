package com.msr.lesson14_反射;

import java.lang.reflect.Method;

/**
 *
 */
public class Test03_获取方法的修饰词_名称 {

    public static void main(String[] args) {
        // 成员函数的格式 : 修饰符   返回值的数据类型    函数名 ( 数据类型  形参名 ,....) {}

        // 成员变量/成员函数/构造器
        // 获取指定类中的所有的变量
        getAllMethod(String.class);
        System.out.println("------------------------------------------");
        getAllMethod(Integer.class);
    }

    private static void getAllMethod(Class<?> c) {
      // 获取函数所在的数组
        Method[] methods = c.getMethods();


        // 遍历
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            // 修饰符 为数值
            int modifiers = method.getModifiers();
            System.out.print(modifiers + "\t");
            // 返回值类型
            Class<?> returnType = method.getReturnType();
            String simpleName = returnType.getSimpleName();
            System.out.print(simpleName + "\t");
            // 获取函数名
            String name = method.getName();
            System.out.print(name + " (");
            // 参数类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                String simpleName1 = parameterTypes[j].getSimpleName();
                System.out.print(simpleName1);

            }
            System.out.println(")");
        }

    }
}
