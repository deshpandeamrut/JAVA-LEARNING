package com.practice.generics;

/**
 * Generic printer class, which can print any object of type E
 * @author Amrut
 *
 * @param <E>
 */
public class Printer<E> {

	E[] elem;
	
	Printer(E[] e){
		this.elem = e;
	}
	
	void print() {
		for (E v : elem) {
			System.out.println(v.toString());
		}
	}
}