package com.practice.multithreading.synchronization.waitAndNotiify;

public class Receiver implements Runnable {

	private MessageTransfer messageTransfer;

	public Receiver(MessageTransfer messageTransfer) {
		super();
		this.messageTransfer = messageTransfer;
	}

	@Override
	public void run() {
		for (String data = messageTransfer.receive(); !data.equals("end"); data = messageTransfer.receive()) {
			System.out.println("Received data-" + data);
		}

	}

}
