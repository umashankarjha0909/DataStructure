package com.linkedlist.practice;

public class LinkedlistATN {

	class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	void printlist(Node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	Node head1, head2, result;
	int carry;

	void push(int val, int list) {
		Node newNode = new Node(val);
		if (list == 1) {
			newNode.next = head1;
			head1 = newNode;
		} else if (list == 2) {
			newNode.next = head2;
			head2 = newNode;
		} else if (list == 3) {
			newNode.next = result;
			result = newNode;
		}
	}
	
	void addsamesize(Node n, Node m) {
		if(n==null)
			return;
		addsamesize(n.next,m.next);
		int sum = (n.val * m.val ) + carry;
		carry = sum/10;
		sum = sum%10;
		push(sum,3);
	}
	
	int getsize(Node head)
    {
        int count = 0;
        while (head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }
	
	void addlists() {
		if (head1 == null){
            result = head2;
            return;
        }
 
        if (head2 == null){
            result = head1;
            return;
        }
        
        int size1 = getsize(head1);
        int size2 = getsize(head2);
        
        if (size1 == size2)
        {
            addsamesize(head1, head2);
        }
        
        if (carry > 0)
            push(carry, 3);
        
	}
	
	public static void main(String[] args) {
		LinkedlistATN list = new LinkedlistATN();
        list.head1 = null;
        list.head2 = null;
        list.result = null;
        list.carry = 0;
        int arr1[] = { 9, 9};
        int arr2[] = { 1, 8};
        
        for (int i = arr1.length - 1; i >= 0; --i)
            list.push(arr1[i], 1);
        
        for (int i = arr2.length - 1; i >= 0; --i)
            list.push(arr2[i], 2);
        
        list.addlists();
        
        list.printlist(list.result);
	}
}
