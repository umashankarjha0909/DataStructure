package com.dp.practice;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int input[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		LIS(input);

	}

	static void LIS(int input[]) {
		int LIS[] = new int[input.length];
		for (int i = 0; i < LIS.length; i++)
			LIS[i] = 1;

		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j]) {
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(input[input.length-1] + " ");
		int counter = LIS[input.length-1];
		for(int i=LIS.length-2;i>=0;i--) {
			if(LIS[i]+1 == counter) {
				counter = LIS[i];
				sb.append(input[i]+" ");
			}
		}
		
		System.out.println(sb.toString());
		for (int i = 0; i < input.length; i++)
			System.out.println(LIS[i]);
	}
}
