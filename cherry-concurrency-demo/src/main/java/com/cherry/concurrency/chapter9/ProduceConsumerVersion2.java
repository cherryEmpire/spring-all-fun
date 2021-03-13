package com.cherry.concurrency.chapter9;

import java.util.stream.Stream;

public class ProduceConsumerVersion2 {

	private int i = 0;

	final private Object LOCK = new Object();

	private volatile boolean isProduced = false;

	public void produce() {
		synchronized (LOCK) {
			if (isProduced) {
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				i++;
				System.out.println("P->" + i);
				LOCK.notify();
				isProduced = true;
			}
		}
	}

	public void consume() {
		synchronized (LOCK) {
			if (isProduced) {
				System.out.println("C->" + i);
				LOCK.notify();
				isProduced = false;
			} else {
				try {
					LOCK.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		ProduceConsumerVersion2 pc = new ProduceConsumerVersion2();
//		new Thread() {
//			@Override
//			public void run() {
//				while (true)
//					pc.produce();
//			}
//		}.start();
//		new Thread() {
//			@Override
//			public void run() {
//				while (true)
//					pc.consume();
//			}
//		}.start();
		
		/*
		 * 会产生程序假死状态,所有线程全部wait,放弃了CPU执行权。全部进入blocked状态。
		 */
		Stream.of("P1", "P2").forEach(n -> new Thread() {
			@Override
			public void run() {
				while (true)
					pc.produce();
			}
		}.start());
		Stream.of("C1", "C2").forEach(n -> new Thread() {
			@Override
			public void run() {
				while (true)
					pc.consume();
			}
		}.start());
	}
}