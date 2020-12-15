package com.msr.lesson01HashSet;

import java.util.HashSet;


public class TestHashSet {

    public static void main(String[] args) {
        // Set : 集      1.不保证迭代顺序  2.元素唯一 : 先通过元素的hashCode()函数判断元素是否相同,不同,直接存储;
//                                                       相同,调用元素的equals()函数进行比较,不同,直接存储,相同,舍弃
        //  |HashSet :
        //      |LinkedHashSet : 保证迭代顺序于插入顺序一致
        //  |TreeSet :
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("JavaSE");
        hashSet.add("JavaEE");
        hashSet.add("MySQL");
        hashSet.add("SQL");
        hashSet.add("HTML");
        hashSet.add("css");
        hashSet.add("css");
        hashSet.add("css");
        hashSet.add("css");

        hashSet.stream().forEach(e -> System.out.println("e = " + e));

        System.out.println("--------------自定义类-----------------------");

        // Array :
        // Arrays : 数组的工具类
        // Collection : 集合
        // Collections : 集合工具类
        // Object
        // Objects : 工具类
        HashSet<User> users = new HashSet<>();

        users.add(new User("Tom",20));
        users.add(new User("Jerry",120));
        users.add(new User("Kitty",80));
        users.add(new User("King",25));
        users.add(new User("King",25));

        users.stream().forEach(user -> System.out.println("user = " + user));
    }
}
