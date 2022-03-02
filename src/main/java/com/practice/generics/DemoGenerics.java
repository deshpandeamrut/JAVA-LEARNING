package com.practice.generics;

public class DemoGenerics {

	public static void main(String[] args) {
		
		System.out.println("Creating an Integer array...");
		Integer[] ar = new Integer[3];
		ar[0] = 1;
		ar[1] = 2;
		ar[2] = 3;
		System.out.println("Printing the created Integer array with Generic Printer");
		Printer<Integer> printer = new Printer<Integer>(ar);
		printer.print();
		
		System.out.println("Creating an array of custome object...");
		MyCustomClass[] myCustomClassArray = new MyCustomClass[2];
		myCustomClassArray[0] = new MyCustomClass("hello", 0);
		myCustomClassArray[1] = new MyCustomClass("How are you?", 1);
		System.out.println("Printing the created custom object array with Generic Printer");
		Printer<MyCustomClass> printer1 = new Printer<MyCustomClass>(myCustomClassArray);
		printer1.print();
	}
}
