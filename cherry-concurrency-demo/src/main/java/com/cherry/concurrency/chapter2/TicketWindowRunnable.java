package com.cherry.concurrency.chapter2;

public class TicketWindowRunnable implements Runnable {

    private final static int MAX = 50;
    private int index = 1;

    @Override
    public void run() {

        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
