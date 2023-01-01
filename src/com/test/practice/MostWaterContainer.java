package com.test.practice;

public class MostWaterContainer {

	public static void main(String[] args) {
		int a[] = { 1, 5, 4, 3 };
		int b[] = { 3, 1, 2, 4, 5 };
		System.out.println(maxArea(a));
		System.out.println(maxArea(b));
	}

	static int maxArea(int[] input) {
		int area = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				area = Math.max(area, Math.min(input[i], input[j]) * (j - i));
			}
		}
		return area;
	}
}
