package com.dp.practice;

public class PaintingFence {

	public static void main(String[] args) {

	}

	static int countWays(int n, int k) {
		int[] dp = new int[n + 1];
		dp[1] = k;
		int same = 0;
		int diff = k;

		for (int i = 2; i <= n; i++) {
			same = diff;
			diff = dp[i - 1] * (k - 1);
			dp[i] = same + diff;
		}
		return dp[n];
	}
}
