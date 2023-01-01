package com.java.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountDistinctWindow {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 }, K = 4;

		// Function call
		secondApproach(arr, arr.length, K);
	}

	static int countWindowDistinct(int win[], int K) {
		int dist_count = 0;

		// Traverse the window
		for (int i = 0; i < K; i++) {
			// Check if element arr[i] exists in arr[0..i-1]
			int j;
			for (j = 0; j < i; j++) {
				if (win[i] == win[j])
					break;
			}
			if (j == i)
				dist_count++;
		}
		return dist_count;
	}

	static void firstApproach(int arr[], int N, int K) {

		for (int i = 0; i < N - K; i++) {
			System.out.println(countWindowDistinct(Arrays.copyOfRange(arr, i, i + K), K));
		}
	}

	static void secondApproach(int arr[], int N, int K) {
		Map<Integer, Integer> map = new HashMap<>();
		int counter = 0;
		for (int i = 0; i < N; i++) {

			if (i < K) {
				if (map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i]) + 1);
				} else {
					map.put(arr[i], 1);
				}
			} else {
				if (map.containsKey(arr[counter])) {
					if (map.get(arr[counter]) > 1)
						map.put(arr[counter], map.get(arr[counter]) - 1);
					else
						map.remove(arr[counter]);
				}

				if (map.containsKey(arr[i])) {
					map.put(arr[i], map.get(arr[i]) + 1);
				} else {
					map.put(arr[i], 1);
				}

				counter++;

			}
			if (i >= K-1)
				System.out.println(map.size());
		}
	}
}
