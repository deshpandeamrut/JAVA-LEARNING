package com.practice.generics.boundedtype;

public class BoundedTypeFGenericClass<E extends Number> {
	E e;
	
	public BoundedTypeFGenericClass(E e){
		this.e = e;
	}
	
	public void print() {
		System.out.println(e);//calls toString as it is already implemented in Object class
		System.out.println(e.intValue()); //It is ok as compiler know it is bounded by Number class other wise it would have given error
	}
	
}
