package com.practice.multithreading.synchronization.waitAndNotiify;

public class MessageTransfer {
	private String data;

	// True if receiver should wait
	// False if sender should wait
	private boolean transfer = true;

	public synchronized void send(String packet) {
		while (!transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread Interrupted");
			}
		}
		transfer = false;

		this.data = packet;
		System.out.println("Message sent-" + data);
		notifyAll();
	}

	public synchronized String receive() {
		while (transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread Interrupted");
			}
		}
		transfer = true;

		String returnPacket = data;
		notifyAll();
		return returnPacket;
	}
}