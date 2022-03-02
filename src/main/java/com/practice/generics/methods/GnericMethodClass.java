package com.practice.generics.methods;

public class GnericMethodClass {
	
	/**
	 * Static method which can take any generic type T
	 * @param <T>
	 * @param t
	 */
	public static <T> void print(T t) {
		System.out.println(t);
	}
}
