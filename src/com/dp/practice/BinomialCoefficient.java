package com.dp.practice;

public class BinomialCoefficient {

	public static void main(String[] args) {
		System.out.println(BCDPSpaceOptimal(4, 2));
	}

	static int BCDPSpaceOptimal(int n, int k) {
		int[] coeff = new int[k + 1];
		coeff[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, k); j > 0; j--) {
				coeff[j] = coeff[j] + coeff[j - 1];
			}
		}
		return coeff[k];
	}

	static int BCDP(int n, int k) {
		int[][] coeff = new int[n + 1][k + 1];
		int i, j;
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i)
					coeff[i][j] = 1;
				else
					coeff[i][j] = coeff[i - 1][j - 1] + coeff[i - 1][j];
			}
		}
		return coeff[n][k];
	}

	static int BCRecursive(int n, int k) {
		if (k == 0 || k == n)
			return 1;
		return BCRecursive(n - 1, k - 1) + BCRecursive(n - 1, k);
	}
}
