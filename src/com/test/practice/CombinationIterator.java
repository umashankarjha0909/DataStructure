package com.test.practice;

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {

	Queue<String> queue;

	public CombinationIterator(String characters, int length) {
		queue = new LinkedList<>();
		generate(characters, 0, "", length, queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

	public static void main(String[] args) {
		CombinationIterator ci = new CombinationIterator("abc", 2);
	}

	public String next() {
		return queue.poll();
	}

	public boolean hasNext() {
		if (!queue.isEmpty())
			return true;
		return false;
	}

	private void generate(String s, int start, String sofar, int k, Queue<String> queue) {
		if (k == 0) {
			queue.add(sofar);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			generate(s, i + 1, sofar + s.charAt(i), k - 1, queue);
		}
	}
}
