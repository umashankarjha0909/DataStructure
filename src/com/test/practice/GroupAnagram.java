package com.test.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String[] args) {
		String[] input = { "cat", "dog", "tac", "god", "act" };

		/*
		 * for(int l=0;l<input.length;l++)
		 * System.out.println(intValue(input[l].toCharArray()));
		 */
		
		Map<Integer, List<String>> hashMap = new HashMap<>();
		

		for (int i = 0; i < input.length; i++) {
			Integer intValue = intValue(input[i].toCharArray());

			if (hashMap.containsKey(intValue)) {
				hashMap.get(intValue).add(input[i]);
			} else {
				List<String> temp = new ArrayList<>();
				temp.add(input[i]);
				hashMap.put(intValue, temp);
			}
		}
		
		System.out.println(hashMap.size());
		for (Integer inte : hashMap.keySet()) {
			List<String> values = hashMap.get(inte);
			if (values.size() > 1)
				System.out.print(values);
		}
	}

	static int intValue(char[] input) {
		int value = 0;
		for (int i = 0; i < input.length; i++)
			value += input[i];
		return value;
	}
}
