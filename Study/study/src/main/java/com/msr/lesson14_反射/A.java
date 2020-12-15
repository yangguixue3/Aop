package com.msr.lesson14_反射;

/**
 * @author 辉
 * @create 2020-12-14 16:26
 * @desc
 */
public class A {

    public void m1() {
        System.out.println("无参无返回值");
    }
    public void m1(int i) {
        System.out.println("无参有返回值 : int " + i);
    }
    public String m1(int num,String str) {
        System.out.println("有参 : int + string 有返回值 : String ");
        return num + str;
    }
}
