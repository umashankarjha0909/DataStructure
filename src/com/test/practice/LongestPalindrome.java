package com.test.practice;

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babcbab"));
	}

	static int longestPalindrome(String input) {
		char[] charInput = input.toCharArray();
		int[][] values = new int[charInput.length][charInput.length];

		for (int i = 0; i < charInput.length; i++) {
			for (int j = 0; j < charInput.length; j++) {
				if (i == j)
					values[i][j] = 1;
			}
		}

		int n = charInput.length;
		int j;
		for(int cl=2;cl<=n;cl++) {
			for(int i=0;i<n-cl+1;i++) {
				j=i+cl-1;
				if(charInput[i]==charInput[j] && cl==2)
					values[i][j]=2;
				else if (charInput[i]==charInput[j])
					values[i][j] = values[i+1][j-1]+2;
				else
					values[i][j] = Math.max(values[i][j-1], values[i+1][j]);
			}
		}

		return values[0][charInput.length - 1];
	}
}
