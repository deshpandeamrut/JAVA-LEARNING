package com.practice.multithreading.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService will be requested to created n number of threads and n number
 * of tasks(by implementing runnable) would be submitted to that thread pool to
 * execute.
 * 
 * @author XKS9
 *
 */
public class ExecutorServiceDemo {

	public static void main(String[] args) {
		// Create tasks
		Task task1 = new Task("task1");
		Task task2 = new Task("task2");
		Task task3 = new Task("task3");

		// Create a thread pool
		ExecutorService pool = Executors.newFixedThreadPool(3);

		pool.execute(task3); // execute
		pool.execute(task1);
		pool.execute(task2);
		pool.shutdown();// stop the pool
	}
}

class Task implements Runnable {

	private String name;

	public Task(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.name + " Thread " + Thread.currentThread().getName() + "Printing : " + i);
		}
	}

}
