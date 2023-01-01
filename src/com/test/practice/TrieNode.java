package com.test.practice;

public class TrieNode {

	TrieNode[] children;
	boolean isWord;

	public TrieNode() {
		this.children = new TrieNode[26];
		this.isWord = false;
	}

}
