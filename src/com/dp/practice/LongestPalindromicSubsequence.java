package com.dp.practice;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		System.out.println(LPS("BABCBAB"));
	}

	static int LPS(String input) {
		char[] in = input.toCharArray();
		int length = input.length();
		int[][] LPS = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					LPS[i][j] = 1;
				}
			}
		}

		int counter = 1;
		while (counter < length) {
			int i = 0;
			for (int j = i + counter; j < length; j++, i++) {
				if (in[i] == in[j]) {
					LPS[i][j] = LPS[i + 1][j - 1] + 2;
				} else {
					LPS[i][j] = Math.max(LPS[i][j - 1], LPS[i + 1][j]);
				}
			}
			counter++;
		}

		return LPS[0][length - 1];
	}
}
