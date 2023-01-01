package com.dp.practice;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		int input[] = { 1, 101, 2, 3, 100, 4, 5 };
		maximumSum(input);
	}

	static void maximumSum(int input[]) {
		LISWithSum[] lis = new LISWithSum[7];
		int length = input.length;
		for (int i = 0; i < length; i++) {
			LISWithSum temp = new LISWithSum(input[i]);
			lis[i] = temp;
		}

		for (int i = 1; i < length; i++) {
			for (int j = 0; j <= i; j++) {
				if (input[i] > input[j] && lis[i].lis < lis[j].lis + 1) {
					lis[i].lis = lis[i].lis + 1;
					lis[i].sum += input[j];
				}
			}
		}

		for (int t = 0; t < lis.length; t++) {
			System.out.println(lis[t].lis + " " + lis[t].sum);
		}
	}
}
