package com.dp.practice;

public class LongestBitonicSubsequence {

	public static void main(String[] args) {
		int input[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int LIS[] = LIS(input);
		int LDS[] = LDS(input);
	}

	static int[] LIS(int[] input) {
		int[] LIS = new int[input.length];

		int length = input.length;
		for (int i = 0; i < input.length; i++)
			LIS[i] = 1;

		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j] && LIS[i] > LIS[j] + 1)
					LIS[j] = LIS[i] + 1;
			}
		}

		return LIS;
	}

	static int[] LDS(int[] input) {
		int[] LIS = new int[input.length];

		int length = input.length;
		for (int i = 0; i < input.length; i++)
			LIS[i] = 1;

		for (int i = length - 2; i >= 0; i--) {
			for (int j = length - 1; j > i; j--) {
				if (input[i] > input[j] && LIS[i] > LIS[j] + 1)
					LIS[j] = LIS[i] + 1;
			}
		}

		return LIS;
	}
}
