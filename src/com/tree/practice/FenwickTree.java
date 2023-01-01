package com.tree.practice;

public class FenwickTree {

	private static int bit[];
	private static int n;

	private static void buildBIT(int a[], int n) {
		bit = new int[n + 1];
		for (int i = 0; i < n; i++)
			updateUtil(i, a[i]);
	}

	private static void updateUtil(int ind, int delta) {
		ind++;
		while (ind <= n) {
			bit[ind] += delta;
			ind += (ind & -ind);
		}
	}

	public static void update(int a[], int ind, int val) {

		int delta = val - a[ind];
		a[ind] = val;
		updateUtil(ind, delta);
	}

	private static int findSum(int ind) {
		// Initializing sum as 0.
		int sum = 0;

		while (ind > 0) {
			sum += bit[ind];
			ind -= (ind & (-ind));
		}
		// Returning sum.
		return sum;
	}

	public static int sumRange(int left, int right) {
		return findSum(right + 1) - (findSum(left));
	}

	public static void main(String[] args) {
		n = 10;
		int a[] = new int[] { 4, 2, 1, 5, 6, 3, 9, 7, 2, 3 };
		buildBIT(a, n);
		System.out.println("Sum of range 2-6 is " + sumRange(2, 6));
		update(a, 5, 12);
		System.out.println("Sum of range 5-9 is " + sumRange(5, 9));
	}
}
