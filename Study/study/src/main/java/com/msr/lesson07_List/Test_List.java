package com.msr.lesson07_List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Test_List {

    public static void main(String[] args) {
        // List特有的功能 : 凡是跟索引值有关的函数都是List特有的.
        List<String> list = new ArrayList<>();

        list.add("aaa");
        list.add("JavaSE0");
        list.add("JavaSE1");
        list.add("JavaSE2");
        list.add("JavaSE3");
        list.add("aaa");

        //  void add(int index, E element)
        //           在列表的指定位置插入指定元素（可选操作）。
        list.add(1, "SQL");
        //  E get(int index)
        //           返回列表中指定位置的元素。
        System.out.println("list.get(1) = " + list.get(1));
        // int indexOf(Object o)
        //   int lastIndexOf(Object o)
        System.out.println("list.indexOf(\"aaa\") = " + list.indexOf("aaa"));
        System.out.println("list.lastIndexOf(\"aaa\") = " + list.lastIndexOf("aaa"));

        // ConcurrentModificationException : 并发异常
        //  ListIterator<E> listIterator()
        // 删除JavaSE3
        for (ListIterator<String> listIterator = list.listIterator() ; listIterator.hasNext() ;){
            String next = listIterator.next();

            if ("JavaSE3".equals(next)) {
                // list.add("xyz");
                listIterator.add("xyz");
            }
        }

        // E remove(int index)
        list.remove(list.size() - 1);
        //   E set(int index, E element)
        list.set(1, "MySQL");
        //   List<E> subList(int fromIndex, int toIndex) : 包含头不包含尾
        List<String> subList = list.subList(1, 3);
        subList.stream().forEach(e -> System.out.println("e = " + e));
        System.out.println("-------------------截取长度---------------------------");

        list.stream()
                .limit(2)
                .forEach(e -> System.out.println("e = " + e));
    }
}
