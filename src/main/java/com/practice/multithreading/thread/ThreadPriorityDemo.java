package com.practice.multithreading.thread;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyPriorityThread());
		t1.setPriority(Thread.MAX_PRIORITY); // setting max priority

		Thread t2 = new Thread(new MyPriorityThread());
		t2.setPriority(Thread.MIN_PRIORITY); // setting min priority
		
		t2.start();
		
		t1.start();

	}
}

class MyPriorityThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread with priority " + Thread.currentThread().getPriority() + " is running ");
	}
}