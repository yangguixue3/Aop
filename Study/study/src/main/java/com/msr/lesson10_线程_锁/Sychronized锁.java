package com.msr.lesson10_线程_锁;

/**
 * 买票
 * 传统 锁synchronized
 */
public class Sychronized锁 {
    public static void main(String[] args) {
        //并发，多线程操作同一个资源类，把资源类丢入线程
        Ticket ticket = new Ticket();
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

    class Ticket{
        private int ticketNum = 30;

        public int getTicketNum() {
            return ticketNum;
        }

        public synchronized void sale(){
            if (ticketNum >0) {
                System.out.println(Thread.currentThread().getName()+"买出了一张票，剩余："+(--ticketNum));
            }
        }

    }
