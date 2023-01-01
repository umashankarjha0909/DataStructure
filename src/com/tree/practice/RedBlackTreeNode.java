package com.tree.practice;

public class RedBlackTreeNode {

	int data;
	RedBlackTreeNode left;
	RedBlackTreeNode right;
	char colour;
	RedBlackTreeNode parent;

	RedBlackTreeNode(int data) {
		super();
		this.data = data;
		this.left = null; // left subtree
		this.right = null; // right subtree
		this.colour = 'R'; // colour . either 'R' or 'B'
		this.parent = null; // required at time of rechecking.
	}

}
