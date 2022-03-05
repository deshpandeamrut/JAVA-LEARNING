package com.practice.multithreading.synchronization.semaphore;

import java.util.concurrent.Semaphore;

/**
 */
public class CorrectSemaphoreDemo {
	public static void main(String[] args) throws InterruptedException {

		Semaphore semaphore = new Semaphore(1);
		Thread t1 = new Thread(new MyThread1(semaphore));// acquires semaphore permits but doesn't release
		Thread t2 = new Thread(new MyGoodThread(semaphore)); // waits indefinitely for acquiring semaphore

		t1.start();
		t1.join();
		t2.start();
		t2.join();
		System.out.println("Program Exiting"); //prints this to indicate success
	}
}

class MyThread1 implements Runnable {

	private Semaphore semaphore;

	public MyThread1(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire(); // Aquisition
			System.out.println("Hello , " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaphore.release();
		} 
	}
}

class MyThread2 implements Runnable {

	private Semaphore semaphore;

	public MyThread2(Semaphore semaphore) {
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