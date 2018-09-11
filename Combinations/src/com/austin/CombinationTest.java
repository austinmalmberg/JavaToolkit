package com.austin;

import java.util.Arrays;

public class CombinationTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Combinations combo = new Combinations();
		combo.get(Arrays.asList(1, 2, 3, 4)).forEach(System.out::println);
		
		System.out.printf("Completed in %d seconds%n", (System.currentTimeMillis() - start) / 1000);
	}
}
