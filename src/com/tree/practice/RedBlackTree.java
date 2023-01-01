package com.tree.practice;

public class RedBlackTree {

	private RedBlackTreeNode root;

	public RedBlackTree() {
		super();
		root = null;
	}

	public void insert(int data)
    {
        if(this.root==null)
        {
            this.root = new RedBlackTreeNode(data);
            this.root.colour = 'B';
        }
        else
            this.root = insertHelp(this.root,data);
    }
	
	RedBlackTreeNode rotateLeft(RedBlackTreeNode node) {
		RedBlackTreeNode x = node.right;
		RedBlackTreeNode y = x.left;

		x.left = node;
		node.right = y;
		node.parent = x;
		if (y != null)
			y.parent = node;
		return x;
	}

	RedBlackTreeNode rotateRight(RedBlackTreeNode node) {
		RedBlackTreeNode x = node.left;
		RedBlackTreeNode y = x.right;
		x.right = node;
		node.left = y;
		node.parent = x;
		if (y != null)
			y.parent = node;
		return (x);
	}

	boolean ll = false;
	boolean rr = false;
	boolean lr = false;
	boolean rl = false;

	RedBlackTreeNode insertHelp(RedBlackTreeNode root, int data) {
		boolean f = false;
		if (root == null)
			return new RedBlackTreeNode(data);
		else if (data < root.data) {
			root.left = insertHelp(root.left, data);
			root.left.parent = root;
			if (root != this.root) {
				if (root.colour == 'R' && root.left.colour == 'R')
					f = true;
			}
		} else {
			root.right = insertHelp(root.right, data);
			root.right.parent = root;
			if (root != this.root) {
				if (root.colour == 'R' && root.right.colour == 'R')
					f = true;
			}
		}

		if (this.ll) // for left rotate.
		{
			root = rotateLeft(root);
			root.colour = 'B';
			root.left.colour = 'R';
			this.ll = false;
		} else if (this.rr) // for right rotate
		{
			root = rotateRight(root);
			root.colour = 'B';
			root.right.colour = 'R';
			this.rr = false;
		} else if (this.rl) // for right and then left
		{
			root.right = rotateRight(root.right);
			root.right.parent = root;
			root = rotateLeft(root);
			root.colour = 'B';
			root.left.colour = 'R';

			this.rl = false;
		} else if (this.lr) // for left and then right.
		{
			root.left = rotateLeft(root.left);
			root.left.parent = root;
			root = rotateRight(root);
			root.colour = 'B';
			root.right.colour = 'R';
			this.lr = false;
		}

		if (f) {
			if (root.parent.right == root) // to check which child is the current node of its parent
			{
				if (root.parent.left == null || root.parent.left.colour == 'B') // case when parent's sibling is black
				{// perform certaing rotation and recolouring. This will be done while
					// backtracking. Hence setting up respective flags.
					if (root.left != null && root.left.colour == 'R')
						this.rl = true;
					else if (root.right != null && root.right.colour == 'R')
						this.ll = true;
				} else // case when parent's sibling is red
				{
					root.parent.left.colour = 'B';
					root.colour = 'B';
					if (root.parent != this.root)
						root.parent.colour = 'R';
				}
			} else {
				if (root.parent.right == null || root.parent.right.colour == 'B') {
					if (root.left != null && root.left.colour == 'R')
						this.rr = true;
					else if (root.right != null && root.right.colour == 'R')
						this.lr = true;
				} else {
					root.parent.right.colour = 'B';
					root.colour = 'B';
					if (root.parent != this.root)
						root.parent.colour = 'R';
				}
			}
			f = false;
		}
		return (root);

	}

}
