package com.practice.multithreading.synchronization.method;

/**
 * The change here is, we will add a synchronized to method instead of
 * synchronizing the sender instance
 */
public class SynchronizedMethodDemo {

	public static void main(String[] args) {
		MessageSender messageSender = new MessageSender();
		Thread personA = new Thread(new MyThread(messageSender, "Hello!"));
		Thread personB = new Thread(new MyThread(messageSender, "How are you?"));

		personA.start();
		personB.start();

		try {
			personA.join();
			personB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MessageSender {

	public synchronized void sendMessage(String msg) {
		/**
		 * Here this method is synchronized
		 */
		System.out.println("Sending msg... " + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Message Sent -  " + msg);
	}
}

class MyThread implements Runnable {

	MessageSender sender;
	String msg;

	public MyThread(MessageSender sender, String msg) {
		super();
		this.sender = sender;
		this.msg = msg;
	}

	@Override
	public void run() {
		sender.sendMessage(msg);
	}
}