package com.test.practice;

public class LastWordLength {

	public static void main(String[] args) {
		System.out.println(lastWordLength("Hello World"));
	}

	static int lastWordLength(final String input) {
		int length = 0;
		String x = input.trim();
		
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == ' ')
				length = 0;
			else
				length++;
		}
		return length;
	}
}
