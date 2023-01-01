package com.dp.practice;

public class KadaneAlgorithm {

	public static void main(String[] args) {
		int input[] = { 4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2 };
		findMaxSubarray(input);
	}

	static void findMaxSubarray(int[] input) {
		int max_so_far = input[0];
		int max_ending_here = 0;
		int start = 0;
		int end = 0;
		int s = 0;

		for (int i = 0; i < input.length; i++) {
			max_ending_here = max_ending_here + input[i];
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				start = s;
				end = i;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s = i + 1;
			}
		}

		System.out.println("Maximum Sum subaray " + max_so_far + " Start index = " + start + " End Index " + end);

	}
}
