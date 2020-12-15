package com.msr.lesson05TreeMap;

import java.util.TreeMap;


public class Test05TreeMap {

    public static void main(String[] args) {
        TreeMap<User, String> userStringTreeMap = new TreeMap<>();

        userStringTreeMap.put(new User("Jerry",120),"广西");
        userStringTreeMap.put(new User("Tom",20),"广西");
        userStringTreeMap.put(new User("Kitty",22),"上海");
        userStringTreeMap.put(new User("King",20),"北京");
        userStringTreeMap.put(new User("LiSi",20),"浙江");
        userStringTreeMap.put(new User("Tom",20),"西藏");

        userStringTreeMap.forEach((user,address) -> {
            System.out.println(user + " : " + address);
        });

        System.out.println("---------------------------------------------------------");

        userStringTreeMap = new TreeMap<>((o1, o2) -> {
            int num = -Integer.compare(o1.getAge(), o2.getAge());
            if (num == 0)
                return -o1.getName().compareTo(o2.getName());
            return num;
        });

        userStringTreeMap.put(new User("Jerry",120),"广西");
        userStringTreeMap.put(new User("Tom",20),"广西");
        userStringTreeMap.put(new User("Kitty",22),"上海");
        userStringTreeMap.put(new User("King",20),"北京");
        userStringTreeMap.put(new User("LiSi",20),"浙江");
        userStringTreeMap.put(new User("Tom",20),"西藏");

        userStringTreeMap.forEach((user,address) -> {
            System.out.println(user + " : " + address);
        });
    }
}
