package com.practice.multithreading.synchronization.reentrantlocks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	public static void main(String[] args) {

		SharedResource sharedResource = new SharedResource(0);

		ReentrantLock reentrantLock = new ReentrantLock();
		Thread t1 = new Thread(() -> {
			boolean done = false;
			while (!done) {
				boolean res = reentrantLock.tryLock();
				try {

					if (res) { // if the lock is acquired
						sharedResource.updateCounter();
						System.out.println("Updated counter!");

						reentrantLock.lock();
						try {
							sharedResource.updateCounter();
							System.out.println("Updated counter again!");
							done = true;
						} catch (Exception e) {
							// TODO: handle exception
						} finally {
							reentrantLock.unlock();
						}
					}
				} catch (Exception e) {
				} finally {
					reentrantLock.unlock();
				}

			}
		});
		Thread t2 = new Thread(() -> {
			boolean done = false;
			while (!done) {
				boolean res = reentrantLock.tryLock();
				try {

					if (res) { // if the lock is acquired
						sharedResource.updateCounter();
						System.out.println("Updated counter!");

						reentrantLock.lock();
						try {
							sharedResource.updateCounter();
							System.out.println("Updated counter again!");
							done = true;
						} catch (Exception e) {
							// TODO: handle exception
						} finally {
							reentrantLock.unlock();
						}
					}
				} catch (Exception e) {
				} finally {
					reentrantLock.unlock();
				}

			}
		});
		t1.start();
		t2.start();
	}

}

class SharedResource {

	private int counter;

	public SharedResource(int counter) {
		super();
		this.counter = counter;
	}

	public void updateCounter() {
		this.counter++;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
