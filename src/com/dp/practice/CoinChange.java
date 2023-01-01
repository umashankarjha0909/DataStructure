package com.dp.practice;

public class CoinChange {

	public static void main(String[] args) {
		int coins[] = { 9, 6, 5, 1 };
		System.out.println(minCoins(coins, coins.length, 11));
	}

	static int coinChangeRecursive(int[] coins, int m, int V) {

		if (V == 0)
			return 0;

		int res = Integer.MAX_VALUE;

		for (int i = 0; i < m; i++) {
			if (coins[i] <= V) {
				int sub_res = coinChangeRecursive(coins, m, V - coins[i]);
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
					res = sub_res + 1;
			}
		}
		return res;
	}

	static int minCoins(int[] coins, int m, int V) {
		int[] table = new int[V + 1];
		table[0] = 0;

		for (int i = 1; i <= V; i++)
			table[i] = Integer.MAX_VALUE;

		for (int i = 1; i <= V; i++) {
			for (int j = 0; j < m; j++) {
				if (coins[j] <= i) {
					int sub_res = table[i - coins[j]];
					if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
						table[i] = sub_res + 1;
				}
			}
		}

		return table[V];
	}
}
