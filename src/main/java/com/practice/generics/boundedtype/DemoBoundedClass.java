package com.practice.generics.boundedtype;

public class DemoBoundedClass {
	
	public static void main(String[] args) {
		BoundedTypeFGenericClass<Integer> be = new BoundedTypeFGenericClass<>(1);
		be.print();
	}
}