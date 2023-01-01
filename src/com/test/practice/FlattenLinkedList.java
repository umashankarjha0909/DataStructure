package com.test.practice;

public class FlattenLinkedList {

	Node head;
	
	class Node {
        int data;
        Node right, down;
        Node(int data)
        {
            this.data = data;
            right = null;
            down = null;
        }
    }
	
	Node merge(Node a, Node b) {
		if(a==null)
			return b;
		if(b==null)
			return a;
		
		Node result;
		if(a.data<b.data) {
			result = a;
			result.down = merge(a.down,b);
		}else {
			result = b;
			result.down = merge(a,b.down);
		}
		return result;
	}
	
	Node flatten(Node root) {
		if(root==null || root.right == null)
			return root;
		root.right = flatten(root.right);
		root = merge(root,root.right);
		return root;
	}
	
	void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }
	
	Node push(Node head_ref, int data) {
		Node newNode = new Node(data);
		newNode.down = head_ref;
		head_ref = newNode;
		return head_ref;
	}
	
	public static void main(String[] args) {
		FlattenLinkedList fll = new FlattenLinkedList();
		fll.head = fll.push(fll.head, 30);
		fll.head = fll.push(fll.head, 8);
		fll.head = fll.push(fll.head, 7);
		fll.head = fll.push(fll.head, 5);
		
		fll.head.right = fll.push(fll.head.right, 20);
		fll.head.right = fll.push(fll.head.right, 20);
		
		fll.head.right.right = fll.push(fll.head.right.right, 50);
		fll.head.right.right = fll.push(fll.head.right.right, 22);
		fll.head.right.right = fll.push(fll.head.right.right, 19);
 
		fll.head.right.right.right
            = fll.push(fll.head.right.right.right, 45);
		fll.head.right.right.right
            = fll.push(fll.head.right.right.right, 40);
		fll.head.right.right.right
            = fll.push(fll.head.right.right.right, 35);
		fll.head.right.right.right
            = fll.push(fll.head.right.right.right, 20);
		
		fll.flatten(fll.head);
		fll.printList();
	}
}
