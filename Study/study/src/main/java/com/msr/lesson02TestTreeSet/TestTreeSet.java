package com.msr.lesson02TestTreeSet;

import java.util.TreeSet;


public class TestTreeSet {

    public static void main(String[] args) {
        // TreeSet : 一定会对元素排序
        //  1.自然排序 : 自定义类实现Comparable接口
        //  2.定制排序 :

        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("JavaSE");
        treeSet.add("JavaEE");
        treeSet.add("MySQL");
        treeSet.add("SQL");
        treeSet.add("HTML");
        treeSet.add("css");

        treeSet.stream().forEach(s -> System.out.println("s = " + s));

        System.out.println("----------自定义类---------------------");

        TreeSet<User> users = new TreeSet<>();

        users.add(new User("Jerry",120));
        users.add(new User("Tom",20));
        users.add(new User("Kitty",80));
        users.add(new User("King",25));
        users.add(new User("King",21));
        users.add(new User("LiSi",21));

        users.stream().forEach(user -> System.out.println("user = " + user));
    }
}
