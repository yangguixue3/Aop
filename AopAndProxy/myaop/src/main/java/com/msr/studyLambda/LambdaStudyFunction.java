package com.msr.studyLambda;

import java.util.function.Function;

/**
 *Function<T, R> 函数型接口 返回R类型
 * R apply(T t); 返回R
 *
 */
public class LambdaStudyFunction {
    //Function<T, R> 函数型接口：

    public static void main(String[] args) {

        String newStr = strHandler("\t\t\t 这是一个函数型接口 ", (str) -> str.trim());
        System.out.println(newStr);
        String subStr = strHandler("这是一个函数型接口", (str) -> str.substring(4, 7));
        System.out.println(subStr);
    }
    //需求：用于处理字符串
    public static String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }
}
