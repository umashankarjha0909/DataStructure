package com.text.algebra;

public class Euclidean {

	public static void main(String[] args) {
		System.out.println(GCD(25, 20));
	}

	static int GCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return GCD(b, a % b);
	}
}
