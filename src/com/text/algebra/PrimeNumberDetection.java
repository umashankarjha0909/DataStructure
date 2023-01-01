package com.text.algebra;

import java.util.Arrays;

public class PrimeNumberDetection {

	public static void main(String[] args) {

		int N = 100;
		boolean[] inputArr = new boolean[N];
		Arrays.fill(inputArr, true);
		for (int i = 2; i*i < N; i++) {

			int j = i * i;
			while (j < N) {
				if (inputArr[j])
					inputArr[j] = false;
				j += i;
			}

		}
		
		for (int i = 0; i < N; i++) {
			if (inputArr[i])
				System.out.println(i + " ");
		}
	}
}
