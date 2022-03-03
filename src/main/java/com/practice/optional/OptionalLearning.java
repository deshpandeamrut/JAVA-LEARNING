package com.practice.optional;

import java.util.Optional;

public class OptionalLearning {

	public static void main(String[] args) {
		OptionalLearning optionalLearning = new OptionalLearning();

		int[] myArray = new int[] { 1, 2, 3 };
		int key = 7;

		if (optionalLearning.searchNumber(myArray, key) == null) {
			System.out.println("Number is not present!");
		} else {
			System.out.println("Number is present!");
		}

		/**
		 * Same functionality with Optional
		 */
		Optional<Integer> optionalResult = optionalLearning.searchNumberWithOptional(myArray, key);
		optionalResult.ifPresentOrElse(x -> System.out.println("<<OPTIONAL>>Number present at :" + x),
				() -> System.out.println("<<OPTIONAL>>key not present!"));

		/**
		 * Optional.OfNullable()
		 */

		Optional<String> optionalNullable = Optional.ofNullable("Hello");

		System.out.println(optionalNullable);
		
		optionalNullable = Optional.ofNullable(null);//returns empty Optional
		
		System.out.println(optionalNullable);

	}

	/**
	 * Returns the index of the matching element in the array or null if not present
	 * 
	 * @param nos
	 * @param key
	 * @return
	 */
	public Integer searchNumber(int[] nos, int key) {
		for (int i = 0; i < nos.length; i++) {
			if (key == nos[i])
				return i;
		}
		return null;
	}

	public Optional<Integer> searchNumberWithOptional(int[] nos, int key) {
		for (int i = 0; i < nos.length; i++) {
			if (key == nos[i])
				return Optional.of(i);
		}
		return Optional.empty();
	}
}
