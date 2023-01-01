package com.test.practice;

import java.util.HashSet;

public class ZeroSumTriplet {

	public static void main(String[] args) {

		int arr[] = { 0, -1, 2, -3, 1 };
		method1(arr);
	}

	static void method1(int input[]) {
		HashSet<Integer> hashSet = new HashSet<>();
		boolean found = false;
		for (int i = 0; i < input.length; i++) {
			for (int j = 1 + 1; j < input.length; j++) {
				int sum = (input[i] + input[j]) * (-1);
				if (hashSet.contains(sum)) {
					System.out.printf("%d %d %d\n", sum, input[i], input[j]);
					found = true;
				} else {
					hashSet.add(sum);
				}

			}
		}
		if (found == false) {
			System.out.printf(" No Triplet Found\n");
		}
	}

}
