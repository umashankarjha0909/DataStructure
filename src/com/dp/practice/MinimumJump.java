package com.dp.practice;

public class MinimumJump {

	public static void main(String[] args) {
		int input[] = { 2, 1, 3, 2, 3, 4, 5, 1, 2, 8 };
		System.out.println(minJump(input));
	}

	static int minJump(int[] input) {
		int[] minJumpCount = new int[input.length];

		for (int i = 0; i < input.length; i++)
			minJumpCount[i] = 0;

		int j = 0;
		int jumpCount = 0;
		for (int i = 0; i < input.length - 1; i++) {
			j = i + input[i];

			for (int k = i; k <= Math.min(j, input.length - 1); k++) {
				jumpCount = minJumpCount[i] + 1;
				if (minJumpCount[k] == 0)
					minJumpCount[k] = minJumpCount[i] + 1;
				else
					minJumpCount[k] = Math.min(minJumpCount[k], jumpCount);
			}
		}
		return minJumpCount[input.length - 1] - 1;
	}
}
