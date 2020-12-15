package com.msr.lesson14_反射;

import java.lang.reflect.Field;

/**
 * 获取 字段 属性
 */
public class Test02_获取字段de属性 {

    public static void main(String[] args) {
        // 成员变量的格式 : 修饰符   数据类型    变量名  ;

        // 成员变量/成员函数/构造器
        // 获取指定类中的所有的变量
        getAllFiled(String.class);
        System.out.println("------------------------------------------");
        getAllFiled(Integer.class);
    }

    private static void getAllFiled(Class<?> c) {
        // 获取所有成员变量所在的数组
        Field[] fields = c.getFields();
        // 变量
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            // 获取修饰符
            int modifiers = field.getModifiers();
            System.out.print(modifiers + "\t");
            // 获取数据类型
            Class<?> type = field.getType();
            String simpleName = type.getSimpleName();
            System.out.print(simpleName + "\t");
            // 获取变量的名字
            String name = field.getName();
            System.out.println(name);
        }

    }
}
