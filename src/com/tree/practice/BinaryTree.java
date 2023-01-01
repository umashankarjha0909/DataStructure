package com.tree.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	public static void main(String[] args) {
		Node root = new Node(26);
		root.setLeft(new Node(10));
		root.setRight(new Node(3));
		root.getLeft().setLeft(new Node(4));
		root.getLeft().setRight(new Node(6));
		root.getRight().setLeft(new Node(0));
		root.getRight().setRight(new Node(3));
		// print(root);
		// System.out.println(findHeight(root));
		// findBranchSum(root);
		// PreOrderTraversal(root);
		// System.out.println(isSumTree(root));

		/*Node root1 = new Node(4);
		root1.setLeft(new Node(2));
		root1.setRight(new Node(5));
		root1.getLeft().setLeft(new Node(1));
		root1.getLeft().setRight(new Node(3));
		System.out.println(isBST(root1));*/
		
		Node tree = new Node(20);
		int k1 = 10, k2 = 25;
        tree.setLeft(new Node(8));
        tree.setRight(new Node(22));
        tree.getLeft().setLeft(new Node(4));
        tree.getLeft().setRight(new Node(12));
        tree.getRight().setLeft(new Node(7));
        tree.getRight().setRight(new Node(11));
        //printRangeNodes(tree,k1,k2);
        
        convertToSumTree(tree);
      levelOrderTraversal(tree);
	}

	static boolean isBST1(Node node) {
		return isBSTUtil1(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	static boolean isBSTUtil1(Node node, int min, int max) {
		if(node == null)
			return true;
		
		if(node.item < min || node.item > max)
			return false;
		
		return isBSTUtil1(node.getLeft(),min,node.item-1) && isBSTUtil1(node.getRight(),node.item+1,max);
	}
	
	static void convertToSumTree(Node node) {
		if(node==null || node.getLeft()==null || node.getRight()==null)
			return;
		convertToSumTree(node.getLeft());
		convertToSumTree(node.getRight());
		node.item = node.getLeft().item + node.getRight().item;
	}
	
	static void levelOrderTraversal(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		queue.add(null);
		System.out.println(node.getItem());
		int height = findHeight(node);
		int counter = 1;
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			if(temp==null && counter < height-1) {
				counter++;
				queue.add(null);
				System.out.println();
				continue;
			}
			if(temp!=null && temp.getLeft()!=null) {
				System.out.print(temp.getLeft().getItem()+" ");
				queue.add(temp.getLeft());
			}
			if(temp!=null && temp.getRight()!=null) {
				System.out.print(temp.getRight().getItem()+" ");
				queue.add(temp.getRight());
			}
		}
		
	}
	
	static void printRangeNodes(Node node, int range1, int range2) {

		if (node == null)
			return;

		if (node.getItem() > range1 && node.getItem() < range2)
			System.out.print(node.getItem() + " ");

		printRangeNodes(node.getLeft(), range1, range2);
		printRangeNodes(node.getRight(), range1, range2);
	}

	static boolean isBST(Node root1) {
		return isBSTUtil(root1, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static boolean isBSTUtil(Node node, int min, int max) {
		if (node == null)
			return true;

		if (node.item < min || node.item > max)
			return false;

		return isBSTUtil(node.getLeft(), min, node.item - 1) && isBSTUtil(node.getRight(), node.item + 1, max);

	}

	public static void print(Node root) {
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

	public static int findHeight(Node root) {
		if (root == null)
			return 0;
		return Math.max(1 + findHeight(root.getLeft()), 1 + findHeight(root.getRight()));
	}

	public static void findBranchSum(Node root) {
		int a[] = new int[10];
		int counter = 0;
		findEachBranchSum(root, a, counter);
	}

	public static void findEachBranchSum(Node root, int[] a, int counter) {

		a[counter] = root.getItem();
		counter++;

		if (root.getLeft() == null && root.getRight() == null) {
			printBranch(a, counter);
			return;
		}

		if (root.getLeft() != null)
			findEachBranchSum(root.getLeft(), a, counter);

		if (root.getRight() != null)
			findEachBranchSum(root.getRight(), a, counter);

	}

	public static void printBranch(int[] a, int counter) {
		int sum = 0;
		for (int i = 0; i < counter; i++) {
			sum += a[i];
			System.out.print(a[i] + "->");
		}
		System.out.print("Sum is " + sum);
		System.out.println();
	}

	public static void inOrderTraversal(Node root) {

		Stack<Node> stack = new Stack<Node>();
		Node current = root;

		while (current != null || stack.size() > 0) {

			while (current != null) {
				stack.add(current);
				current = current.getLeft();
			}

			current = stack.pop();
			System.out.println(current.getItem());
			current = current.getRight();
		}

	}

	public static void PreOrderTraversal(Node root) {

		Queue<Node> queue = new LinkedList<Node>();
		Node current = root;

		while (current != null || queue.size() > 0) {
			while (current != null) {
				queue.add(current);
				System.out.println(current.getItem());
				current = current.getLeft();
			}
			current = queue.poll();
			current = current.getRight();
		}

	}

	public static boolean isSumTree(Node root) {

		int leftSum;
		int rightSum;

		// If leaf node then return true
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return true;

		leftSum = sum(root.getLeft());
		rightSum = sum(root.getRight());

		if ((root.getItem() == leftSum + rightSum) && isSumTree(root.getLeft()) && isSumTree(root.getRight()))
			return true;

		return false;

	}

	static int sum(Node node) {
		if (node == null)
			return 0;
		return sum(node.getLeft()) + node.item + sum(node.getRight());
	}

}
