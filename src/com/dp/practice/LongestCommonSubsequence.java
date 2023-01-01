package com.dp.practice;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String input1 = "AGGTAB";
		String input2 = "GXTXAYB";
		findLCS(input1.toCharArray(),input2.toCharArray());
	}
	
	static void findLCS(char[] input1,char[] input2) {
		int[][] table = new int[input1.length+1][input2.length+1];
		
		for(int i=0;i<input1.length;i++)
			table[0][i] = 0;
		
		for(int i=0;i<input2.length;i++)
			table[i][0] = 0;
		
		for(int i=1;i<=input1.length;i++) {
			for(int j=1;j<=input2.length;j++) {
				if(input1[i-1]==input2[j-1]) {
					table[i][j] = table[i-1][j-1]+1;
				} else {
					table[i][j] = Math.max(table[i][j-1],table[i-1][j]);
				}
			}
		}
		
		System.out.println(table[input1.length][input2.length]);
	}
}
