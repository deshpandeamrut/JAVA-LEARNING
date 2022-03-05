package com.practice.multithreading.synchronization.futureandcallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		int n = 2;

		Callable<Integer> callable = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 0; i < n; i++) {
					sum += i;
				}
				return sum;
			}
		};

		Future<Integer> future = threadPool.submit(callable);
		int sum = future.get(); // synchronous call
		System.out.println("Sum :" + sum);

		/*
		 * Asycnhronous Calls
		 */
		Future<Integer> futureAsync = threadPool.submit(() -> { // java 8 style for a change
			Thread.sleep(2000); // faking the operation time to delay
			return 100;
		});
		while (!futureAsync.isDone()) { // non blocking call
			System.out.println("Working on it...");
			Thread.sleep(1000);
		}
		int asycResult = futureAsync.get(); // get blocks the operation that is why it is called after isDone returns
											// true
		System.out.println("Asyc call result: " + asycResult);

		/*
		 * Asycnhronous Calls and canceling future
		 */
		Future<Integer> futureAsync2 = threadPool.submit(() -> { // java 8 style for a change
			Thread.sleep(5000); // faking the operation time to delay
			return 200;
		});
		int counter = 0;
		while (!futureAsync2.isDone()) { // non blocking call
			System.out.println("Working on async2 ...");
			Thread.sleep(1000);
			if (counter > 1) {
				futureAsync2.cancel(true); // cancel if it exceeds the time
			}
			counter++;

		}
		int asycResult2 = futureAsync2.get(); // get blocks the operation that is why it is called after isDone returns
												// true
		System.out.println("Asyc2 call result2: " + asycResult2);

		threadPool.shutdown();

	}
}
