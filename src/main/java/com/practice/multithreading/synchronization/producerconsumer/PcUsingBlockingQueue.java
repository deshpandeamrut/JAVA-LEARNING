package com.practice.multithreading.synchronization.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Java provides a BlockingQueue interface that is thread-safe. In other words,
 * multiple threads can add and remove from this queue without any concurrency
 * issues.
 * 
 * Its put() method blocks the calling thread if the queue is full. Similarly,
 * if the queue is empty, its take() method blocks the calling thread.
 *
 */
public class PcUsingBlockingQueue {

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
		Thread p = new Thread(new ProducerBQ(blockingQueue));
		Thread c = new Thread(new ConsumerBQ(blockingQueue));

		p.start();
		c.start();
	}

}

class ProducerBQ implements Runnable {
	BlockingQueue<Integer> queue;

	public ProducerBQ(BlockingQueue<Integer> blockingQueue) {
		this.queue = blockingQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				queue.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Produced " + i);
		}
	}

}

class ConsumerBQ implements Runnable {
	BlockingQueue<Integer> queue;

	public ConsumerBQ(BlockingQueue<Integer> blockingQueue) {
		this.queue = blockingQueue;
	}

	@Override
	public void run() {
		while (true) {
			int val;
			try {
				val = queue.take();
				System.out.println("Consumed - " + val);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
