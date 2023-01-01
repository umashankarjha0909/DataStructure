package com.test.practice;

import java.util.TreeMap;
import java.util.Vector;

public class VerticalOrderTraversal {

	static class Node {
		int key;
		Node left;
		Node right;

		// Constructor
		Node(int data) {
			key = data;
			left = null;
			right = null;
		}
	}

	static void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> map) {
		if (root == null)
			return;

		Vector<Integer> get = map.get(hd);
		if (get == null) {
			get = new Vector<>();
			get.add(root.key);
		} else
			get.add(root.key);

		map.put(hd, get);

		getVerticalOrder(root.left, hd - 1, map);
		getVerticalOrder(root.right, hd + 1, map);
	}

	static void printVerticalOrder(Node root) {
		TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
		int hd = 0;
		getVerticalOrder(root, hd, map);
		for (java.util.Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		System.out.println("Vertical Order traversal is");
		printVerticalOrder(root);
	}
}
