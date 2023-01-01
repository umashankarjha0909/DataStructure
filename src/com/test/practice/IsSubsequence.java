package com.test.practice;

public class IsSubsequence {

	public static void main(String[] args) {
		String input1 = "AXY";
		String input2 = "ADXCPY";
		System.out.println(isSubSequence(input1, input2));
	}

	static boolean isSubSequence(String input1, String input2) {

		char[] subString = input1.toCharArray();
		char[] mainString = input2.toCharArray();
		int counter = 0;
		for (int i = 0; i < mainString.length; i++) {
			if (mainString[i] == subString[counter])
				counter++;
		}

		if (counter == input1.length())
			return true;
		return false;
	}
}
