package com.msr.lesson03TestTreeSet;

import java.util.Comparator;

public class NameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        // 比较规则
        int num = Integer.compare(o1.getAge(), o2.getAge());
        if (num == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return num ;
    }
}
