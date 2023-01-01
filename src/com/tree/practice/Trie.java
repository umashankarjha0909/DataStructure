package com.tree.practice;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode(); // root is empty
	}

	private class TrieNode {
		private TrieNode[] children;
		private boolean isWord;

		public TrieNode() {
			this.children = new TrieNode[26];
			this.isWord = false;
		}
	}

	public void insert(String word) {

		if (word == null || word.isEmpty())
			throw new IllegalArgumentException("Invalid Input");

		word = word.toLowerCase();

		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (current.children[index] == null) {
				TrieNode node = new TrieNode();
				current.children[index] = node;
				current = node;
			} else {
				current = current.children[index];
			}
		}
		current.isWord = true;
	}

	public boolean search(String word) {
		TrieNode current = root;
		word = word.toLowerCase();
		for (int k = 0; k < word.length(); k++) {
			char temp = word.charAt(k);
			int index = temp - 'a';
			if (current.children[index] == null)
				return false;
			else
				current = current.children[index];
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("hello");
		trie.insert("world");
		System.out.println(trie.search("hello"));
	}
}
