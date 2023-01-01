package com.tree.practice;

import java.util.LinkedList;
import java.util.Queue;

public class BuildSegmentTree {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		Node root = new Node(1);
		root.setLeft(new Node(3));
		root.setRight(new Node(5));
		root.getLeft().setLeft(new Node(7));
		root.getLeft().setRight(new Node(9));
		root.getRight().setLeft(new Node(11));
		root.getRight().setRight(new Node(12));
		BuildSegmentTree bst = new BuildSegmentTree();
		Node root1 = bst.buildSegmentTree(root, 0, arr.length - 1);
		System.out.println(bst.isSumTree(root1));
		bst.print(root);
	}
	
	Node buildSegmentTree(Node root, int left, int right) {
		int mid = left + (right - left) / 2;
		int sum = 0;
		
		if (root.getLeft() == null && root.getRight() == null)
			return root;
		
		if (root.getLeft() != null)
			buildSegmentTree(root.getLeft(), left, mid);

		if (root.getRight() != null)
			buildSegmentTree(root.getRight(), mid + 1, right);

		if (root.getLeft() != null)
			sum += root.getLeft().getItem();

		if (root.getRight() != null)
			sum += root.getRight().getItem();

		root.setItem(sum);

		return root;
	}

	public void print(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node item = queue.poll();
			System.out.println(item.getItem());
			if (item.getLeft() != null)
				queue.add(item.getLeft());
			if (item.getRight() != null)
				queue.add(item.getRight());
		}
	}

	boolean isSumTree(Node root) {

		int leftSum;
		int rightSum;

		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return true;

		leftSum = sum(root.getLeft());
		rightSum = sum(root.getRight());

		if ((root.getItem() == leftSum + rightSum) && isSumTree(root.getLeft()) && isSumTree(root.getRight()))
			return true;

		return false;
	}

	int sum(Node root) {
		if (root == null)
			return 0;
		return  sum(root.getLeft()) + sum(root.getRight());
	}

}
