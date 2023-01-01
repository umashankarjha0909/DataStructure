package com.test.practice;

import java.util.LinkedList;

public class HashMapDesignUsingLL {

	private LinkedList<Entry>[] map;
	private int SIZE;

	public HashMapDesignUsingLL(int capacity) {
		map = new LinkedList[capacity];
		SIZE = capacity;
	}

	public int get(int key) {
		int bucket = key % SIZE;
		LinkedList<Entry> entries = map[bucket];
		if (entries == null)
			return -1;
		for (Entry entry : entries) {
			if (entry.key == key)
				return entry.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		int bucket = key % SIZE;
		Entry entry = new Entry(key, value);
		LinkedList<Entry> entries;
		if (map[bucket] != null) {
			entries = map[bucket];
			entries.add(entry);
		} else {
			entries = new LinkedList<>();
			map[bucket] = entries;
		}
	}

	public void remove(int key) {
		int bucket = key % SIZE;
		LinkedList<Entry> entries = map[bucket];
		if (entries != null) {
			for (Entry entry : entries) {
				if (entry.key == key)
					entry = null;
			}
		}
	}
}
