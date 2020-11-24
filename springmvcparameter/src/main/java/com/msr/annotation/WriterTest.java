package com.msr.annotation;

import java.lang.reflect.Method;

@Writer(name = "动力", age = 12)
public class WriterTest {

    @Writer(name = "马油", age = 10)
    public void writeBlog() {
        System.out.println("writing blog");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("com.msr.annotation.WriterTest");
        if (c.isAnnotationPresent(Writer.class)) {
            Writer w = (Writer) c.getAnnotation(Writer.class);
            System.out.println("name:" + w.name() + "   age:" + w.age());
        }
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Writer.class)) {
                Writer w = method.getAnnotation(Writer.class);
                System.out.println("name:" + w.name() + "   age:" + w.age());
            }
        }
    }
}