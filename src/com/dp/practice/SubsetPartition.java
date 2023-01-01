package com.dp.practice;

public class SubsetPartition {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 5, 9, 12 };
		int n = arr.length;
		System.out.println(findPartition(arr, n));
	}

	static boolean isSubsetSum(int arr[], int n, int sum) {

		if (sum == 0)
			return true;

		if (n == 0 && sum != 0)
			return false;

		if (arr[n - 1] < sum)
			isSubsetSum(arr, n - 1, sum);

		return isSubsetSum(arr, n - 1, sum - arr[n - 1]) || isSubsetSum(arr, n - 1, sum);
	}

	static boolean findPartition(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		return isSubsetSum(arr, n, sum / 2);
	}
}
