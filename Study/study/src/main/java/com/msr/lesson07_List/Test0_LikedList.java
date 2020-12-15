package com.msr.lesson07_List;

import java.util.LinkedList;


public class Test0_LikedList {

    public static void main(String[] args) {
        //
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("ccc");
        linkedList.add("ddd");

        // 在头部添加
        linkedList.addFirst("0000");
        linkedList.addLast("end");

        //  boolean offer(E e)
        //           将指定元素添加到此列表的末尾（最后一个元素）。
        //  boolean offerFirst(E e)
        //           在此列表的开头插入指定的元素。
        //  boolean offerLast(E e)
        //           在此列表末尾插入指定的元素。

        // linkedList.clear();

        // System.out.println("linkedList.getFirst() = " + linkedList.getFirst());
        //  E peek()
        //           获取但不移除此列表的头（第一个元素）。
        //  E peekFirst()
        //           获取但不移除此列表的第一个元素；如果此列表为空，则返回 null。
        //  E peekLast()
        //           获取但不移除此列表的最后一个元素；如果此列表为空，则返回 null。

        System.out.println("linkedList.peekFirst() = " + linkedList.peekFirst());

        //  E poll()
        //           获取并移除此列表的头（第一个元素）
        //  E pollFirst()
        //           获取并移除此列表的第一个元素；如果此列表为空，则返回 null。
        //  E pollLast()
        //           获取并移除此列表的最后一个元素；如果此列表为空，则返回 null。

        System.out.println("linkedList.pollLast() = " + linkedList.pollLast());

        linkedList.stream().forEach(e -> System.out.println("e = " + e));
    }
}
