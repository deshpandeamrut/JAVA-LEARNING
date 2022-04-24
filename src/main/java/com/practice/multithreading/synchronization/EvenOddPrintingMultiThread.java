package com.practice.multithreading.synchronization;

public class EvenOddPrintingMultiThread {

	int counter = 1;

	static int n;

	public static void main(String[] args) {
		
		EvenOddPrintingMultiThread obj = new EvenOddPrintingMultiThread();
		n =10;
		Thread t1 = new Thread(()-> {obj.printOddNumber();});
		Thread t2 = new Thread(()-> {obj.printEven();});
		
		t1.start();
		t2.start();
	}

	public void printOddNumber()
    {
        synchronized (this)
        {
            while (counter < n) {
                if (counter % 2 == 0) {
                    try {
                        wait();
                    }
                    catch (
                        InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd- "+counter);
                counter++;
                notify();
            }
        }
    }

	public void printEven() {
		synchronized (this) {
			while (counter < n) {
				if (counter % 2 == 1) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Even- " + counter);
				counter++;
				notify();
			}
		}

	}
}
