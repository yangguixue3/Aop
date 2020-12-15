package com.msr.lesson08_泛型;

/**
 * 类的自定义泛型
 * @param <T>
 */
public class Dao <T> {//

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    // 普通方法的自定义泛型  格式: 声明类型 <E> 返回值类型 犯法名 (E e)
    public <E> void print(E e){
        System.out.println("e = " + e);
        System.out.println("t = " + t);
    }

    // 静态函数 : static修饰的函数  :  静态的只能访问静态的,不能访问非静态
    public static <K> void staticPrint(K k){
        System.out.println("k = " + k);
        // System.out.println("t = " + t);
    }
}
