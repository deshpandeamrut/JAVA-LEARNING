package com.practice.tricky;

import java.util.ArrayList;
import java.util.List;

/**
 * How to make Immuatbe class? 
 * 1. Mark class as final 
 * 2. Mark all members as final and private 
 * 3. Implement only getters 
 * 4. Always initialize and return wrapper classes (mutable objects) by doing deep copy
 * 
 * @author XKS9
 *
 */

public class ImmutableObjectDemo {

	public static void main(String[] args) {
		MyImmuatableObject myImmuatableObject = new MyImmuatableObject("Amrut");
		System.out.println(myImmuatableObject.getName());// there is only getter so cant modify anyting

		/* Incorrect Demo */
		List<String> originalList = new ArrayList<String>();
		originalList.add("Amrut");
		MyIncorrectImmuatableObjectWithList myIncorrectImmuatableObjectWithList = new MyIncorrectImmuatableObjectWithList(
				originalList);

		System.out.println(myIncorrectImmuatableObjectWithList.getNames().size());
		List<String> myList = myIncorrectImmuatableObjectWithList.getNames();
		myList.add("Deshpande");// adds the entry to original list and ith eobject is mutated

		System.out.println(myIncorrectImmuatableObjectWithList.getNames().size());

		/** COrrect Demo */
		System.out.println("Correct Implementation");
		List<String> originalList2 = new ArrayList<String>();
		originalList2.add("Amrut");
		MyCorrectImmuatableObjectWithList myCorrectImmuatableObjectWithList = new MyCorrectImmuatableObjectWithList(
				originalList2);

		System.out.println("Size Originally-" + myCorrectImmuatableObjectWithList.getNames().size());
		List<String> myList2 = myCorrectImmuatableObjectWithList.getNames();
		myList2.add("Deshpande");// adds the entry to original list and ith eobject is mutated

		System.out.println("Size after change-" + myCorrectImmuatableObjectWithList.getNames().size());
	}
}

final class MyImmuatableObject {
	private final String name;

	public String getName() {
		return name;
	}

	public MyImmuatableObject(String name) {
		super();
		this.name = name;
	}
}

final class MyIncorrectImmuatableObjectWithList {
	private final List<String> names;

	public MyIncorrectImmuatableObjectWithList(List<String> names) {
		super();
		this.names = names;
	}

	public List<String> getNames() {
		return names;
	}

}

final class MyCorrectImmuatableObjectWithList {
	private final List<String> names;

	public MyCorrectImmuatableObjectWithList(List<String> names) {
		super();
		this.names = new ArrayList<String>();
		for (String string : names) {
			this.names.add(string);
		}
	}

	public List<String> getNames() {
		List<String> newList = new ArrayList<String>();
		for (String string : this.names) {
			newList.add(string);
		}
		return newList;
	}
}