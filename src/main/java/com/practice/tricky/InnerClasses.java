package com.practice.tricky;

import com.practice.tricky.MyClass.Innerclass;

public class InnerClasses {
	public static void main(String[] args) {

		MyClass myClass = new MyClass();
		myClass.print();

		Innerclass innerClass = myClass.new Innerclass();
		innerClass.print();

		MyClass.StaticInnerClass staticInnerClass = new MyClass.StaticInnerClass();
		staticInnerClass.print();
	}
}

class MyClass {

	String name;

	class Innerclass {
		String id;

		public void print() {
			System.out.println("This is from non static inner class");
		}
	}

	static class StaticInnerClass {
		public void print() {
			System.out.println("This is my nested static class");
		}

	}

	public void print() {

		class Methodclass {
			public void print() {
				System.out.println("This is method inner class");
			}
		}
		// can be instantiated only in this method
		Methodclass methodclass = new Methodclass();
		methodclass.print();

	}
}