package com.practice.tricky;

import java.util.HashMap;
import java.util.Map;

public class CollectionsTrickWithSameHashCOdeMap {
	public static void main(String[] args) {

		Emp1 e1 = new Emp1("ABC", 1);
		Emp1 e3 = new Emp1("ABC", 1);
		Emp1 e2 = new Emp1("ABCD", 1);

		Map<Emp1, Integer> myMap = new HashMap<>();
		myMap.put(e1, 1);
		myMap.put(e2, 2);
		myMap.put(e3, 3);//same as e1's content so it will be overriden

		System.out.println("Map size-" + myMap.size());
		System.out.println("e1 val- "+myMap.get(e1)); //overriden value

	}
}

class Emp1 {

	String name;

	int id;

	public Emp1(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	/**
	 * Invoked everytime there is a put or get or delete
	 */
	@Override
	public int hashCode() {
		System.out.println("Invoked hascode()");

		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;

//		return 1;
	}

	/**
	 * This gets invoked only when hashcode is returned as same for two objects
	 */
	@Override
	public boolean equals(Object obj) {
		System.out.println("Euqls invoked!");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp1 other = (Emp1) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}