package com.practice.interview;

public class SlidingWindows {

	public static void main(String[] args) {
		int input[] = { 1, -2, 3, 4, 5, 3, 4, -1 };
		int k = 3;
		int[] result = new int[input.length - k+1];
		int counter = -1;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i <= input.length - k; i++) {
			max = Integer.MIN_VALUE;
			counter++;
			for (int j = i; j < i + k; j++) {
				if (input[j] > max)
					max = input[j];
			}
			result[counter] = max;
			System.out.println(max);
		}
	}

}
