package com.msr.lesson04HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;


public class Test04HashMap {

    public static void main(String[] args) {
        // HashSet类似于HashMap
        // HashMap : JDK8.0之前数据结构 : 哈希表(数组+链表)
        // HashMap : JDK8.0开始数据结构 : 哈希表(数组+链表) + 二叉树
        // 用户和籍贯
        HashMap<User, String> userStringHashMap = new HashMap<>();

        userStringHashMap.put(new User("Tom",20),"广西");
        userStringHashMap.put(new User("Jerry",120),"广西");
        userStringHashMap.put(new User("Kitty",22),"上海");
        userStringHashMap.put(new User("King",20),"北京");
        userStringHashMap.put(new User("LiSi",20),"浙江");
        userStringHashMap.put(new User("Tom",20),"西藏");

        userStringHashMap.forEach((user,address) -> {
            System.out.println(user + " : " + address);
        });
        System.out.println("-------------------------------");
        userStringHashMap = new LinkedHashMap<>();

        userStringHashMap.put(new User("Tom",20),"广西");
        userStringHashMap.put(new User("Jerry",120),"广西");
        userStringHashMap.put(new User("Kitty",22),"上海");
        userStringHashMap.put(new User("King",20),"北京");
        userStringHashMap.put(new User("LiSi",20),"浙江");
        userStringHashMap.put(new User("Tom",20),"西藏");

        userStringHashMap.forEach((user,address) -> {
            System.out.println(user + " : " + address);
        });
    }
}
