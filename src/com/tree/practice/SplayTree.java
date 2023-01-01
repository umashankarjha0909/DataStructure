package com.tree.practice;

public class SplayTree {

	static class node {

		int key;
		node left, right;
	};

	public static void main(String[] args) {
		node root = newNode(100); 
	    root.left = newNode(50); 
	    root.right = newNode(200); 
	    root.left.left = newNode(40); 
	    root.left.left.left = newNode(30); 
	    root.left.left.left.left = newNode(20); 
	  
	    root = search(root, 10); 
	    System.out.print("Preorder traversal of the" +  
	                     " modified Splay tree is \n"); 
	    preOrder(root); 
	}
	
	static void preOrder(node root) 
	{ 
	    if (root != null) 
	    { 
	        System.out.print(root.key + " "); 
	        preOrder(root.left); 
	        preOrder(root.right); 
	    } 
	} 
	
	static node search(node root, int key) 
	{ 
	    return splay(root, key); 
	} 
	
	static node newNode(int key) {
		node Node = new node();
		Node.key = key;
		Node.left = Node.right = null;
		return (Node);
	}

	static node rightRotate(node x) {
		node y = x.left;
		x.left = y.right;
		y.right = x;
		return y;
	}

	static node leftRotate(node x) {
		node y = x.right;
		x.right = y.left;
		y.left = x;
		return y;
	}

	static node splay(node root, int key) {
		if (root == null || root.key == key)
			return root;

		if (root.key > key) {
			if (root.left == null)
				return root;
			// Zig-Zig (Left Left)
			if (root.left.key > key) {
				// First recursively bring the
				// key as root of left-left
				root.left.left = splay(root.left.left, key);

				// Do first rotation for root,
				// second rotation is done after else
				root = rightRotate(root);
			} else if (root.left.key < key) // Zig-Zag (Left Right)
			{
				// First recursively bring
				// the key as root of left-right
				root.left.right = splay(root.left.right, key);

				// Do first rotation for root.left
				if (root.left.right != null)
					root.left = leftRotate(root.left);
			}

			// Do second rotation for root
			return (root.left == null) ? root : rightRotate(root);
		} else {
			if (root.right == null)
				return root;
			if (root.right.key > key) {
				// Bring the key as root of right-left
				root.right.left = splay(root.right.left, key);

				// Do first rotation for root.right
				if (root.right.left != null)
					root.right = rightRotate(root.right);
			} else if (root.right.key < key)// Zag-Zag (Right Right)
			{
				// Bring the key as root of
				// right-right and do first rotation
				root.right.right = splay(root.right.right, key);
				root = leftRotate(root);
			}

			// Do second rotation for root
			return (root.right == null) ? root : leftRotate(root);
		}
	}
}
