package com.practice.multithreading.deadlock;

public class DeadLockDemo {
	public static void main(String[] args) {

		DeadLockDemo obj = new DeadLockDemo();
		Shared s1 = new Shared();
		Shared s2 = new Shared();

		Thread t1 = new Thread(new Thread1(s1, s2));
		Thread t2 = new Thread(new Thread2(s1, s2));
		
		t1.start();
		t2.start();
	}

}

class Shared {

	public Shared() {
	}

	synchronized void method1(Shared s1) throws InterruptedException {
		System.out.println("Inside m1");
		Thread.sleep(1000);
		s1.methodInner();
	}

	synchronized void methodInner() {

		System.out.println("Inside inner method");
	}
}

class Thread1 implements Runnable {

	Shared s1;
	Shared s2;

	public Thread1(Shared s1, Shared s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		try {
			s1.method1(s2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Thread2 implements Runnable {

	Shared s1;
	Shared s2;

	public Thread2(Shared s1, Shared s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		try {
			s2.method1(s1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}