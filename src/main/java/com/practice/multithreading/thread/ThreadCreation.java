package com.practice.multithreading.thread;
/**
 * There are two ways to create a thread:

extends Thread class
implement Runnable interface
 * @author XKS9
 *
 */
public class ThreadCreation {

	public static void main(String[] args) {
		
		MyThread myThread = new MyThread(); //Creating new thread via Thread class extension
		myThread.start();
		
		Thread myRunnableThread =  new Thread(new MyThreadViaRunnable()); //New Thread by passing runnable instance
		myRunnableThread.start();
		Thread t3 = new Thread(()->  {
			System.out.println("Running with lamda - functional interface implementation");
		});
		
		t3.start();
	}
}

class MyThread extends Thread{
	
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread is running via extending Thread class");
	}
}

class MyThreadViaRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("MyThreadViaRunnable is running via implementing Runnable interface");
	}
	
}