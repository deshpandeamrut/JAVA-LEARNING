package com.practice.tricky;

/**
 * JAVA is pass by value for primitives
 * 
 * But for Objects it is also called pass-by-value but tricky to understand
 * 
 * In the below example when car object is passed to method1(), the nethod
 * assigns a new object to car but the caller (main method) only know abt the
 * original address it had sent and the content in that address is same hence it
 * will not affect
 * 
 * However in the second ex, when the object is passed the change is done on the
 * same objects (address) and hence main method refers to that as the same
 * object
 * 
 * Java is pass by value. Well, pass by reference value. Oh well, even better is
 * pass-by-copy-of-the-variable-value! ;)
 * 
 * @author XKS9
 *
 */
public class JavaPassByBalue {
	public static void main(String[] args) {

		Car car = new Car("i10");
		JavaPassByBalue javaPassByBalue = new JavaPassByBalue();

		System.out.println("Car name " + car.name);
		javaPassByBalue.method1(car);
		System.out.println("Car name in main after method1- " + car.name);

		System.out.println("--------------------------");
		Car car1 = new Car("tiago");
		System.out.println("Car1 name " + car1.name);
		javaPassByBalue.method2(car1);
		System.out.println("Car name in main after method2- " + car1.name);
	}

	public void method1(Car car) {
		/*
		 * car objects's address's value is passed
		 */
		System.out.println("Car name in method1-" + car.name);

		car = new Car("Duster"); // changing the original address here
		System.out.println("New car name-" + car.name);
	}

	public void method2(Car car) {
		System.out.println("Car name in method2-" + car.name);

		car.name = "Duster";
		System.out.println("New car name-" + car.name);
	}
}

class Car {
	String name;

	public Car(String name) {
		super();
		this.name = name;
	}
}