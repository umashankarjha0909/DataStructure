package com.dp.practice;

public class CountWays {

	// Count number of ways to reach a given score in a game
	public static void main(String[] args) {
		System.out.println(count1(14));
	}

	static int count(int n) {
		int[] table = new int[n + 1];
		table[0] = 1;

		for (int i = 3; i <= n; i++)
			table[i] += table[i - 3];

		for (int i = 5; i <= n; i++)
			table[i] += table[i - 5];

		for (int i = 10; i <= n; i++)
			table[i] += table[i - 10];

		return table[n];
	}
	
	static int count1(int n) {
		int[] table = new int[n + 1];
		table[0] = 1;

		for (int i = 2; i <= n; i++)
			table[i] += table[i - 2];

		for (int i = 6; i <= n; i++)
			table[i] += table[i - 6];

		return table[n];
	}

}
