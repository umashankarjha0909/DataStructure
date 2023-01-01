package com.test.practice;

public class SubArraySum {

	public static void main(String[] args) {

		int input[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		subArraySum(input, input.length, 22);
	}

	static void subArraySum(int arr[], int n, int sum) {
		int currentSum = arr[0], start = 0, i;
		for (i = 1; i <= n; i++) {

			while (currentSum > sum && start < i - 1) {
				currentSum -= arr[start];
				start++;
			}

			if (currentSum == sum) {
				System.out.println("Sum found between " + start + " and " + (i - 1));
			}
			if (i < n)
				currentSum += arr[i];
		}
	}
}
