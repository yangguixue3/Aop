package com.msr.lesson10_线程_锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *    synchronized 是 Java 内置的关键字，Lock 是一个类；
 *     synchronized 无法判断获取锁的状态，Lock 可以判断是否获取到了锁；
 *     synchronized 会自动释放锁，Lock 必须手动释放锁，如果不释放，将会造成死锁；
 *     synchronized 如果有多个线程，线程1获得锁执行时，其他线程只能傻傻的等待，Lock 锁不一定要等下去
 *     synchronized 是可重入锁，不可中断，非公平锁，Lock 可重入锁，可以判断锁，非公平锁（可以设置，自由度更高）；
 *     synchronized 适合锁少量代码的同步问题，Lock 适合锁大量的代码。
 */
public class Lock锁 {
    public static void main(String[] args) {
        Ticket01 ticket = new Ticket01();
        new Thread(() -> {
            for (int i = 0; i<100 && (ticket.getTicketNum() <=0 ? false :true); i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket.sale();
            }
        },"Tom").start();

        new Thread(() -> {
            for (int i = 0; i<100 && (ticket.getTicketNum() <=0 ? false :true); i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket.sale();
            }
        },"King").start();

    }


}
class Ticket01{
    private int ticketNum = 30;
    /**
     * 使用 Lock 锁三步曲，1、声明锁；2、加锁；3解锁
     */
    Lock lock = new ReentrantLock();//1、声明锁

    public int getTicketNum() {
        return ticketNum;
    }

    public synchronized void sale(){
        lock.lock();//2、加锁
        try {
            if (ticketNum >0) {
                System.out.println(Thread.currentThread().getName()+"买出了一张票，剩余："+(--ticketNum));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//3解锁
        }
    }

}

