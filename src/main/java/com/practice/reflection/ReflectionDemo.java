package com.practice.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		MyReflectionClass obj = new MyReflectionClass("a");
		Class c = obj.getClass();
		Constructor[] cs =  c.getConstructors();
		for(Constructor con : cs) {
			System.out.println(con.getName());
		}
		
		/**
		 * Get Field of the class
		 */
		Field field = c.getDeclaredField("field1");
		field.setAccessible(true);
		
		Method method =  c.getDeclaredMethod("printSPrivate");
		
		method.setAccessible(true);//make private member of a class as accessible
		
		
		MyReflectionClass obj2 = new MyReflectionClass("Hi Obj2");
		
		method.invoke(obj2, null);//invoke a private member from other object
		
		
	}
}

class MyReflectionClass{
	
	private String field1;
	
	public MyReflectionClass(String s) {
		this.field1 = s;
	}
	
	public void printS() {
		System.out.println(field1);
	}
	
	private void printSPrivate() {
		System.out.println(field1);
	}
}