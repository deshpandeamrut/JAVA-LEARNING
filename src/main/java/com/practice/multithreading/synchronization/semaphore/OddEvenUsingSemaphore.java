package com.practice.multithreading.synchronization.semaphore;

import java.util.concurrent.Semaphore;

public class OddEvenUsingSemaphore {
	public static void main(String[] args) {
		SharedPrinter sp = new SharedPrinter();
		
		Thread  evenThread = new Thread(new EvenThread(sp),"even");
		Thread oddThread = new Thread(new OddThread(sp),"odd");
		
		evenThread.start();
		oddThread.start();
	}
	
}
class SharedPrinter{
	private Semaphore sOdd = new Semaphore(1);
	private Semaphore sEven = new Semaphore(0);
	
	void printOdd(int num){
		try {
			sOdd.acquire();//gets the permit only if the value is 1, we know initially it is set to 1, decrements it by 1 -> 0
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":" + num);
		sEven.release();//releases the permit, menaing sets the value of sEven to 1
	}
	
	void printEven(int num){
		try {
			sEven.acquire();//gets the permit only if the value is 1,after it is released by oddThread; it will decrement the value from 1 to 0
			System.out.println(sOdd. availablePermits());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":" + num);
		sOdd.release();
	}
}

class EvenThread implements Runnable{
	SharedPrinter sp;
	
	public EvenThread(SharedPrinter sp) {
		this.sp = sp;
	}
	
	@Override
	public void run() {
		for(int i =2;i<100;i=i+2) {
			sp.printEven(i);
		}
	}
	
}

class OddThread implements Runnable{
	SharedPrinter sp;
	
	public OddThread(SharedPrinter sp) {
		this.sp = sp;
	}
	
	@Override
	public void run() {
		for(int i =1;i<100;i=i+2) {
			sp.printOdd(i);
		}
	}
	
}