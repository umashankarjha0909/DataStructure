package com.tree.practice;

public class Node {
	
	int item;
	Node left,right;
	
	public Node() {
		
	}
	
	public Node(int item) {
		this.item = item;
		left = right = null;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public static void main(String[] args) {
		
	}
	

}
