package com.practice.multithreading.thread;

public class DaemonThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new MyDaemonThread());
		t.setDaemon(true); // setting Daemon to true to make it Dameon thread

		t.start();
		t.join(); // need this as the JVM will not wait for Daemon thread to complete
	}
}

class MyDaemonThread implements Runnable {

	@Override
	public void run() {
		System.out.println("My Daemon thread is running!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
