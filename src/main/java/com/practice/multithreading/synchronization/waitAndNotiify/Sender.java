package com.practice.multithreading.synchronization.waitAndNotiify;

public class Sender implements Runnable {

	private MessageTransfer messageTransfer;

	private String[] data;

	public Sender(MessageTransfer messageTransfer, String[] data) {
		super();
		this.messageTransfer = messageTransfer;
		this.data = data;
	}

	@Override
	public void run() {
		for (String string : data) {
			messageTransfer.send(string);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
