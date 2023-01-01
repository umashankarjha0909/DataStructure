package com.test.practice;

import java.util.Stack;

public class StreamChecker {

	private Stack<Character> stack;
	private TrieNode root;

	public StreamChecker() {
		stack = new Stack<>();
		root = new TrieNode();
	}

	public static void main(String[] args) {
		StreamChecker sc = new StreamChecker();
		
		sc.insert("dc");
		sc.insert("f");
		sc.insert("lk");
		
		System.out.println(sc.search("lk"));
		
		sc.query('a');
		sc.query('b');
		sc.query('c');
		sc.query('d');
		sc.query('e');
		sc.query('f');
		sc.query('g');
		sc.query('h');
		sc.query('i');
		sc.query('j');
		sc.query('k');
		sc.query('l');
		sc.streamSearch(sc);

		
		
	}

	void query(char input) {
		stack.add(input);
	}

	void streamSearch(StreamChecker sc) {
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
			//System.out.println(sb.toString());
			if (sc.search(sb.toString())) {
				System.out.println(sb.toString() + " found in the list");
			}
		}
	}

	public void insert(String word) {
		char[] input = word.toCharArray();
		TrieNode current = root;
		for (int i = 0; i < input.length; i++) {
			int location = input[i] - 'a';
			if (current.children[location] == null) {
				TrieNode temp = new TrieNode();
				current.children[location] = temp;
				current = temp;
			} else {
				current = current.children[location];
			}
		}
		current.isWord = true;
	}

	public boolean search(String word) {
		char[] input = word.trim().toCharArray();
		TrieNode current = root;
		for (int i = 0; i < input.length; i++) {
			int location = input[i] - 'a';
			if (current.children[location] != null)
				current = current.children[location];
			else
				return false;
		}

		return true;
	}
}
