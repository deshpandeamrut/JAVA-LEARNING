package com.practice.tricky;

import java.util.HashSet;
import java.util.Set;

public class CollectionsTrickWithSameHashCOde {
	public static void main(String[] args) {

		Emp e1 = new Emp("ABC", 1);
		Emp e3 = new Emp("ABC", 1);
		Emp e2 = new Emp("ABCD", 1);

		Set<Emp> mySet = new HashSet<>();

		mySet.add(e1);
		mySet.add(e2);
		mySet.add(e3);

		for (Emp emp : mySet) {
			System.out.println(emp.name);
		}
		System.out.println("Set contains e1?" +mySet.contains(e1));
		System.out.println("Set contains e2?" +mySet.contains(e2));
		System.out.println("Set Size="+mySet.size());

		System.out.println("if e1==e2?-" + (e1 == e2));
		System.out.println("if e1.equals_e2?-" + e1.equals(e2));

	}
}

class Emp {

	String name;

	int id;

	public Emp(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public int hashCode() {

		
		  final int prime = 31; int result = 1; result = prime * result + id; result =
		  prime * result + ((name == null) ? 0 : name.hashCode()); return result;
		 

//		return 1;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Emp other = (Emp) obj;
//		if (id != other.id)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}

}