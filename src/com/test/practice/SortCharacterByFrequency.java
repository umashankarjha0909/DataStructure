package com.test.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharacterByFrequency {

	public static void main(String[] args) {
		String input = "geeksforgeeks";
		characterByFrequency(input);
	}

	static void characterByFrequency(String input) {
		char[] inputArray = input.toCharArray();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < inputArray.length; i++) {
			char nextchar = inputArray[i];
			if (map.containsKey(nextchar)) {
				map.put(nextchar, map.get(nextchar) + 1);
			} else {
				map.put(nextchar, 1);
			}
		}
		
		Map<Character, Integer> updatedMap = SortHashMap.sortByValue(map);
		
		for(Entry<Character,Integer> entry : updatedMap.entrySet()) {
			System.out.println(entry.getKey()+" " +entry.getValue());
		}
	}
}
