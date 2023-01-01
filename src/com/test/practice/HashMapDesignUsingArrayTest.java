package com.test.practice;

public class HashMapDesignUsingArrayTest {

	public static void main(String[] args) {
		HashMapDesignUsingArray hmd = new HashMapDesignUsingArray(100);
		for (int i = 0; i < 50; i++)
			hmd.put(i, i);
		
		System.out.println(hmd.get(5));
	}
}
