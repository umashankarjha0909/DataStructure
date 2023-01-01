package com.test.practice;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

	Deque<Integer> deQueue;
	HashSet<Integer> hashSet;

	private final int CACHE_SIZE;

	LRUCache(int capacity) {
		deQueue = new LinkedList<>();
		hashSet = new HashSet<>();
		CACHE_SIZE = capacity;
	}

	public void refer(int page) {

		if (deQueue.size() == CACHE_SIZE) {
			int last = deQueue.removeLast();
			hashSet.remove(last);
		}

		deQueue.push(page);
		hashSet.add(page);
	}

	public void display() {
		Iterator<Integer> itr = deQueue.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(5);
		cache.display();
	}
}
