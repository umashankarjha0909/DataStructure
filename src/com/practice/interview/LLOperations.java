package com.practice.interview;

import java.util.HashMap;
import java.util.Map;

public class LLOperations {

	ListNode createLL(int arr[]) {
		ListNode root = new ListNode(arr[0]);
		ListNode current = root;
		for (int i = 1; i < arr.length; i++) {
			ListNode temp = new ListNode(arr[i]);
			root.next = temp;
			root = temp;
		}

		return current;
	}

	void display(ListNode root) {
		while (root != null) {
			System.out.println(root.data);
			root = root.next;
		}
	}

	ListNode reverse(ListNode root) {
		ListNode newNode = null;
		ListNode current = root;
		ListNode reverseLL = null;
		while (current != null) {
			newNode = new ListNode(current.data);
			newNode.next = reverseLL;
			reverseLL = newNode;
			current = current.next;
		}
		return reverseLL;
	}

	int getMiddelLL(ListNode root) {

		ListNode slowPtr = root;
		ListNode fastPtr = root;
		while (fastPtr.next != null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		return slowPtr.data;
	}

	ListNode removeLoop(ListNode root) {
		Map<ListNode, String> map = new HashMap<>();
		ListNode current = root;
		while (current.next != null) {
			if (map.get(current.next) != null) {
				if (map.get(current.next).equalsIgnoreCase("VISITED")) {
					current.next = null;
					break;
				}
			} else {
				map.put(current, "VISITED");
			}
			current = current.next;
		}
		
		return root;
	}

	public static void main(String[] args) {
		
		LLOperations llops = new LLOperations();
		ListNode root = new ListNode(3);
		
		root.next = new ListNode(4);
		root.next.next = new ListNode(5);
		//root.next.next.next = new ListNode(6);
		root.next.next.next = root.next;
		ListNode root1 = llops.removeLoop(root);
		llops.display(root1);
	}
}
