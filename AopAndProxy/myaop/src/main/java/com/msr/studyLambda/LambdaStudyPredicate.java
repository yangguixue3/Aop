package com.msr.studyLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaStudyPredicate {


    /**
     * Predicate<T> 断定型接口：是否满足约束条件，返回boolean值
     * boolean test(T t);
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "Java8", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);
        for (String str : strList) {
            System.out.println(str);
        }
    }

    //需求：将满足条件的字符串，放入集合中
    public static List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if(pre.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }
}
