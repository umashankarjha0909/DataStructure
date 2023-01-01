package com.dp.practice;

public class EditDistance {

	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";
		System.out.println(editDistance(str1, str2, str1.length()-1, str2.length()-1));

	}

	static int editDistance(String input1, String input2, int M, int N) {

		if (M == 0)
			return N;

		if (N == 0)
			return M;

		if (input1.charAt(M) == input2.charAt(N))
			return editDistance(input1, input2, M - 1, N - 1);
		else
			return 1 + Math.min(
					Math.min(editDistance(input1, input2, M, N - 1), editDistance(input1, input2, M - 1, N)),
					editDistance(input1, input2, M - 1, N - 1));
	}

}
