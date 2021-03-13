package com.cherry.concurrency.chapter10;

import java.util.Collection;

public interface Lock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeOutException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();

    class TimeOutException extends Exception {

        private static final long serialVersionUID = -1085050040900868917L;

        public TimeOutException(String message) {
            super(message);
        }
    }

}
