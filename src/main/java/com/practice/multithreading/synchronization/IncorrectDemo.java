package com.practice.multithreading.synchronization;

/**
 * This program shows why we need synchronized
 * 
 * If this is executed then the this executions results in race condition,
 * meaning you can't predict the sequence of execution
 * 
 *
 */
public class IncorrectDemo {

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
		sender.sendMessage(msg);
	}

}