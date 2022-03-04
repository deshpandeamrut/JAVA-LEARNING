package com.practice.multithreading.synchronization.object;

/**
 * The change here is, we will add a synchronized sender, meaning at any moment
 * only one person can send a msg, hence between sendning and sent there will
 * not be anything
 * 
 *
 */
public class SynchronizedObjectDemo {

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

	public void sendMessage(String msg) {
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
		synchronized (sender) { // sender object is synchronized
			/**
			 * This is object instance type of synchronization as the monitor (called as a
			 * lock which is available on every object) Only one thread can have it at
			 * anytime, so the thread will acquire this lock and locks it and executes then
			 * releases lock making way for other threads
			 **/
			sender.sendMessage(msg);
		}
	}
}