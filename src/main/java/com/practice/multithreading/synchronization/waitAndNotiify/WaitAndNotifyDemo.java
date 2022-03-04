package com.practice.multithreading.synchronization.waitAndNotiify;

public class WaitAndNotifyDemo {

	public static void main(String[] args) {
		MessageTransfer messageTransfer = new MessageTransfer();
		Thread sender = new Thread(new Sender(messageTransfer, new String("Hi, Hello, How are you?,end").split(",")));
		Thread receiver = new Thread(new Receiver(messageTransfer));

		sender.start();
		receiver.start();
	}
}
