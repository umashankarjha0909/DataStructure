package com.test.practice;

public class HashMapDesignUsingArray {

	int[] map;

	public HashMapDesignUsingArray(int capacity) {
		map = new int[capacity];
		for (int i = 0; i < map.length; i++)
			map[i] = -1;
	}
	
	public void put(int key,int value) {
		map[key] = value;
	}
	
	public int get(int key) {
		return map[key];
	}
	
	public void remove(int key) {
		map[key]=-1;
	}

}
