package com.practice.generics;

/**
 * Custom type which can be passed as type E to printer method
 * @author Amrut
 *
 */
public class MyCustomClass {

	private String name;
	
	private int id;
	
	
	public MyCustomClass() {
		super();
	}

	public MyCustomClass(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "MyCustomClass [name=" + name + ", id=" + id + "]";
	}
	
	
}
