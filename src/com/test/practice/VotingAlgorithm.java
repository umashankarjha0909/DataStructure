package com.test.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VotingAlgorithm {

	public static void main(String[] args) {
		int[] input = { 1, 1, 1, 2, 3, 5 };
		System.out.println(findMajority(input));
	}

	static int findMajority(int[] input) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		int key = 0;
		for (int i = 0; i < input.length; i++) {

			if (map.containsKey(input[i])) {
				map.put(input[i], map.get(input[i]) + 1);
			} else {
				map.put(input[i], 1);
			}

		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				key = entry.getKey();
			}
		}
		return max;
	}
}
