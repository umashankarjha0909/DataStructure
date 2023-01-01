package com.dp.practice;

public class ZeroOneKnapsack {

	public static void main(String[] args) {
		int[] weight = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };
		int w = 50;
		System.out.println(knapsack(w, weight, value, 3));
	}

	static int knapsack(int w, int[] weight, int[] value, int n) {
		int[][] temp = new int[n + 1][w + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= w; j++) {
				if (i == 0 || j == 0)
					temp[i][j] = 0;
				else if (weight[i - 1] < w)
					temp[i][j] = Math.max(value[i - 1] + temp[i - 1][w - weight[i - 1]], temp[i - 1][w]);
				else
					temp[i][j] = temp[i - 1][j];
			}
		}
		return temp[n][w];
	}
}
