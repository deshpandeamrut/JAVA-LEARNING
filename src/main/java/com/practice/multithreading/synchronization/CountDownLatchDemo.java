package com.practice.multithreading.synchronization;

import java.util.concurrent.CountDownLatch;

/**
 * Countdown latch is a synchronization aid, it can be used to block
 * single/multiple threads till rest of the tasks are completed
 * 
 * A CountDownLatch object is initialized with the number of tasks/threads it is
 * required to wait for. Multiple threads can block and wait for the
 * CountDownLatch object to reach zero by invoking await(). Every time a thread
 * finishes its work, the thread invokes countDown() which decrements the
 * counter by 1. Once the count reaches zero, threads waiting on the await()
 * method are notified and resume execution.
 * 
 * Note: The countdownlatch counter can't be reset 
 *
 */
public class CountDownLatchDemo {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(2); // countdown till two

		Thread t1 = new Thread(new Runnable() {
//			CountDownLatch countDownLatch;

			@Override
			public void run() {
				System.out.println("Car washing done!");
				countDownLatch.countDown();
			}
		});

		Thread t2 = new Thread(new Runnable() {
//			CountDownLatch countDownLatch;

			@Override
			public void run() {
				System.out.println("Car Compounding done!");
				countDownLatch.countDown();
			}
		});

		t1.start();
		t2.start();
		try {
			countDownLatch.await();
			System.out.println("Car Polishing done!");

			System.out.println("Car care complete");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}