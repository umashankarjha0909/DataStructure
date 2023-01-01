package com.test.practice;

import java.util.HashMap;

public class WordPattern {

	public static void main(String[] args) {
		System.out.println(isPattern("dog cat cat dot", "abba"));
	}

	static boolean isPattern(String input, String pattern) {

		String[] inp = input.split(" ");
		HashMap<Character, String> hashMap = new HashMap<>();

		if (inp.length != pattern.length())
			return false;

		for (int i = 0; i < pattern.length(); i++) {

			if (hashMap.get(pattern.charAt(i)) == null) {
				hashMap.put(pattern.charAt(i), inp[i]);
			} else {
				String t = hashMap.get(pattern.charAt(i));
				if (!t.equals(inp[i]))
					return false;
			}

		}

		return true;
	}
}
