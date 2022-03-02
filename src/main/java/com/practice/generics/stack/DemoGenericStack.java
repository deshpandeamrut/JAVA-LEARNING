package com.practice.generics.stack;

public class DemoGenericStack {

	public static void main(String[] args) throws Exception {
		GenericsStack<Integer> intStack = new GenericsStack<>(3);

		intStack.push(1);
		intStack.push(2);
		intStack.push(3);
		intStack.push(4);
		intStack.push(5);

		System.out.println("Popping - " + intStack.pop());
		System.out.println("Popping - " + intStack.pop());
		intStack.push(5);
		intStack.printStack();

		GenericsStack<String> stack = new GenericsStack<>(3);

		stack.push("Hello");
		stack.push("Howdy");
		stack.push("HRU");
		System.out.println("Popping - " + stack.pop());
		System.out.println("Popping - " + stack.pop());
		System.out.println("Popping - " + stack.pop());
		System.out.println("Popping - " + stack.pop());
		
		stack.printStack();
	}
}
