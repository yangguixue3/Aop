package com.msr.lesson08_泛型;

import java.util.ArrayList;

/**
 *       ? 通配符，声明泛型时，返回值前不需要<>
 *       ? extends E : （上限） 的通配符   即只能是E或者E的子类
 *       ? super E : （下限） 的通配符 即只能是E或E的父类
 */
public class Test_通配符 {

    public static void main(String[] args) {
        // 现在有三个集合,用一个函数遍历三个集合
        // String
        // Number : 抽象类 Number 是 BigDecimal、BigInteger、Byte、Double、Float、Integer、Long 和 Short 类的超类。
        // Integer :

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("MyBatis");
        arrayList1.add("spring");
        arrayList1.add("springmvc");
        arrayList1.add("JDBC");
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        arrayList2.add(3306);
        arrayList2.add(1521);
        arrayList2.add(8080);
        arrayList2.add(1099);
        arrayList2.add(9527);

        ArrayList<Number> arrayList3 = new ArrayList<>();
        arrayList3.add(3.1415926D);
        arrayList3.add(10L);
        arrayList3.add(3.1415926F);
        arrayList3.add(9527);

//         printAllArrayList(arrayList1);
        printAllArrayList(arrayList2);
        printAllArrayList(arrayList3);

    }
    /*
     * ? extends E :
     * ? super E :
     */

    public static void printAllArrayList(ArrayList<? super Integer> arrayList) {
        arrayList.stream().forEach(t -> System.out.println("t = " + t));
    }

    // public static void printAllArrayList(ArrayList<? extends Number> arrayList) {
    //     arrayList.stream().forEach(t -> System.out.println("t = " + t));
    // }

    // public static void printAllArrayList(ArrayList<?> arrayList) {
    //     arrayList.stream().forEach(t -> {
    //         if (t instanceof String) {
    //             String s = (String) t;
    //             System.out.println("s = " + s.length());
    //         }
    //         if (t instanceof Integer) {
    //             Integer s = (Integer) t;
    //             System.out.println("Integer = " + s);
    //         }
    //         if (t instanceof Number) {
    //             Number s = (Number) t;
    //             System.out.println("Number = " + s);
    //         }
    //     });
    // }

    // public static <T> void printAllArrayList(ArrayList<T> arrayList) {
    //     arrayList.stream().forEach(t -> System.out.println("t = " + t));
    // }
}
