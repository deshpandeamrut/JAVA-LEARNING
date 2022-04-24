package com.practice.multithreading.synchronization.producerconsumer;

import java.util.LinkedList;

public class ProducerConsumerProblem {

	public static void main(String[] args) {

		pc pc = new pc();

		Thread p = new Thread(new Producer(pc));

		Thread c = new Thread(new Consumer(pc));

		p.start();
		c.start();
	}
}

class Producer implements Runnable {
	pc pc;

	public Producer(pc pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		try {
			pc.produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {
	pc pc;

	public Consumer(pc pc) {
		this.pc = pc;
	}

	@Override
	public void run() {
		try {
			pc.consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class pc {

	LinkedList<String> list = new LinkedList<>();

	public void produce() throws InterruptedException {
		int i = 0;
		while (true) { // to handle spurious wakes
			synchronized (this) {//NOSONAR
				while (list.size() == 5) {
					wait();
				}
				list.add(i+ "");
				System.out.println("Produced : " + i);
				i = i+1;
				notifyAll();
				Thread.sleep(1000);
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {//NOSONAR
			synchronized (this) {
				if (list.isEmpty()) {
					wait();
				}
				String val = list.removeFirst();
				System.out.println("Received " + val);
				notify();
				Thread.sleep(1000);
			}
		}
	}

}