package com.practice.generics.stack;

import java.util.Iterator;

public class GenericsStack<E> {

	private int size;
	private StackElement stackElement;
	private int top;
	private StackElement topElement;

	private class StackElement {
		private E ele;
		private StackElement next;
	}

	public GenericsStack(int size) {
		top = -1;
		this.size = size;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return size == top;
	}

	public void push(E e) {
		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}
		StackElement se = new StackElement();
		se.ele = e;
		se.next = topElement;
		topElement = se;
		top++;
	}

	public E pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("STack is empty!");
		}
		E popE = topElement.ele;
		topElement = topElement.next;
		top--;
		return popE;
	}

	public void printStack() {
		StackElement s = topElement;
		while (s != null) {
			System.out.println(s.ele);
			s = s.next;
		}
	}
	
	public E peek() throws Exception {
		if(isEmpty()) {
			throw new Exception("STack is empty!");
		}
		return topElement.ele;
	}
}
