package com.practice.multithreading.synchronization.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Semaphore permits acquired should match with semahore releases
 * 
 */
public class IncorrectSemaphoreDemo {
	public static void main(String[] args) throws InterruptedException {

		Semaphore semaphore = new Semaphore(1);
		Thread t1 = new Thread(new MyBadThread(semaphore));// acquires semaphore permits but doesn't release
		Thread t2 = new Thread(new MyGoodThread(semaphore)); // waits indefinitely for acquiring semaphore

		t1.start();
		t1.join();
		t2.start();
		t2.join();
		System.out.println("Program Exiting");
	}
}
/**
 * Bad guy without release of semaphore permit
 *
 */
class MyBadThread implements Runnable {

	private Semaphore semaphore;

	public MyBadThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire(); // Aquisition and never releases
			System.out.println("Hello , " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyGoodThread implements Runnable {

	private Semaphore semaphore;

	public MyGoodThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println("Hello , " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}