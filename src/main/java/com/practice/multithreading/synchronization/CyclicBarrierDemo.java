package com.practice.multithreading.synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
			// This is executed after other two thread have called await method
			@Override
			public void run() {
				// This is executed only after other two have reached
				System.out.println("Tiago and i10 reached,lets us start to Coorg");
				//cyclic barrier can be reset to start again
			}
		});

		Thread tiago = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Travelling to Blore in Tiago");
				System.out.println("Tiago reached blore!");
				try {
					cyclicBarrier.await();
					System.out.println("Tiago resumed!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}

			}
		});

		Thread i10 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Travelling to Blore in i10");
				System.out.println("i10 reached blore!");
				try {
					cyclicBarrier.await();
					System.out.println("i10 resumed!");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}

			}
		});

		tiago.start();
		i10.start();
	}

}
