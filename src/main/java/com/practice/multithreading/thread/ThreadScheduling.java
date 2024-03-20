package com.practice.multithreading.thread;

public class ThreadScheduling {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyScheduledThread());
		t1.start();

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("I am a main scheduled thread , val :" + i);
		}
	}
}

class MyScheduledThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("I am a new scheduled thread , val :" + i);
		}

	}
}