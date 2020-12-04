package com.msr.studyLambda;

import java.util.function.Consumer;

public class LambdaStudyConsumer {
    /**
     * Consumer<T> 消费型接口
     * void accept(T t);
     * 返回类型void
     * @param args
     */
    public static void main(String[] args) {
        hello("张三", (m) -> System.out.println("你好：" + m));

    }

    public static void hello(String st, Consumer<String> con){
        con.accept(st);
    }
}
