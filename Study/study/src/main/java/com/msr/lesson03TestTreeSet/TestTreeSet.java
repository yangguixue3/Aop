package com.msr.lesson03TestTreeSet;

import java.util.TreeSet;


public class TestTreeSet {

    public static void main(String[] args) {
        // TreeSet : 一定会对元素排序
        //  1.自然排序 : 自定义类实现Comparable接口
        //  2.定制排序 : Comparator
        // a.编写比较器
        // b.创建比较器对象
        NameComparator nameComparator = new NameComparator();
        // c.将比较对象给到集合
        TreeSet<User> users = new TreeSet<>(nameComparator);

        users.add(new User("Jerry",120));
        users.add(new User("Tom",20));
        users.add(new User("Kitty",80));
        users.add(new User("King",25));
        users.add(new User("King",21));
        users.add(new User("LiSi",21));

        users.stream().forEach(user -> System.out.println("user = " + user));

        System.out.println("--------------匿名内部类-------------------");

        // users = new TreeSet<>(new Comparator<User>() {
        //     @Override
        //     public int compare(User o1, User o2) {
        //         // 比较规则
        //         int num = Integer.compare(o1.getAge(), o2.getAge());
        //         if (num == 0) {
        //             return o1.getName().compareTo(o2.getName());
        //         }
        //         return num ;
        //     }
        // });
        System.out.println("--------------lambda表达式使用前提 : 函数式接口(接口中有且只有一个抽象函数)-------------------");

        users = new TreeSet<>((o1,o2) -> {
                // 比较规则
                int num = Integer.compare(o1.getAge(), o2.getAge());
                if (num == 0) {
                    return o1.getName().compareTo(o2.getName());
                }
                return num ;
        });

        System.out.println("users = " + users);

        users.add(new User("Jerry",120));
        users.add(new User("Tom",20));
        users.add(new User("Kitty",80));
        users.add(new User("King",25));
        users.add(new User("King",21));
        users.add(new User("LiSi",21));

        users.stream().forEach(user -> System.out.println("user = " + user));


    }
}
