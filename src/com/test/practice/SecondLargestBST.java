package com.test.practice;

public class SecondLargestBST {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(20);
		root.right.right = new Node(30);
		Inorder(root);
	}

	static void Inorder(Node root) {
		if (root != null) {
			Inorder(root.right);
			System.out.println(root.data);
			Inorder(root.left);
		}
	}
}
