package com.practice.multithreading.synchronization.waitAndNotiify;

public class TestPrint {

	public static void main(String[] args) {
		Printer p = new Printer();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				p.printEven();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				p.printOdd();
			}
		});

		t1.start();
		t2.start();
	}
}

class Printer {
	int counter = 0;

//	void printEven() {
//		synchronized (this) {
//			while (counter < 100) {
//				if (counter % 2 == 0) {
//					try {
//						wait();
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println(counter);
//					counter++;
//					notify();
//				}
//			}
//		}
//	}
	public void printEven() {
		synchronized (this) {
			while (counter < 100) {
				if (counter % 2 == 0) {
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

	void printOdd() {
		synchronized (this) {
			while (counter < 100) {
				if (counter % 2 == 1) {
					System.out.println(counter);
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					counter++;
					notify();
				}
			}
		}
	}
	public void printOddNumber()
    {
        synchronized (this)
        {
            while (counter < 100) {
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

}