package com.msr.lesson10_线程_锁;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 运行现象:同时生成10个线程，读线程 同时出现 => 读读共享
 *        结束后，才开始写                => 读写互斥
 *        写是逐个出现                   => 写写互斥
 */

public class ReadWriteLock_读写锁 {
    public static void main(String[] args) {
        Book book = new Book();

        for (int i = 0; i < 5; i++) {

            new Thread(() -> {
                book.get();
            },"线程tom"+String.valueOf(i)).start();

        }

        for (int i = 0; i < 5; i++) {
            int num = i;
            new Thread(()->{
                book.put(String.format("Hello%s", String.valueOf(num)));
            },"线程writer"+String.valueOf(num)).start();
        }


    }
}
class Book{

    private volatile Map map = new HashMap();//1 保证内存可见性 2 禁止指令重排
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //写
    public void put(String data){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"准备写入");
            Thread.sleep(3000);
            map.put("name",data);
            System.out.println(Thread.currentThread().getName()+"写入:"+data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    //读
    public void get(){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"准备读取");
            Thread.sleep(3000);
            String o = (String)map.get("name");
            System.out.println(Thread.currentThread().getName()+"读取成功获取:"+o);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}