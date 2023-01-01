package com.test.practice;

public class MultiplyTwoLL {

	public static void main(String[] args) {

		// create first list 9->4->6
		LLNode first = new LLNode(9);
		first.next = new LLNode(4);
		first.next.next = new LLNode(6);
		System.out.print("First List is: ");
		printList(first);

		// create second list 8->4
		LLNode second = new LLNode(8);
		second.next = new LLNode(4);
		System.out.print("Second List is: ");
		printList(second);

		// Multiply the two lists and see result
		System.out.print("Result is: ");
		System.out.println(multiplyTwoLists(first, second));
	}

	static long multiplyTwoLists(LLNode first, LLNode second) {

		long N = 1000000007;
		long num1 = 0, num2 = 0;

		while (first != null || second != null) {
			if (first != null) {
				num1 = ((num1 * 10) % N) + first.data;
				first = first.next;
			}

			if (second != null) {
				num2 = ((num2 * 10) % N) + second.data;
				second = second.next;
			}
		}
		return ((num1 % N) * (num2 % N)) % N;

	}

	static void printList(LLNode node) {
		while (node != null) {
			System.out.print(node.data);
			if (node.next != null)
				System.out.print("->");
			node = node.next;
		}
		System.out.println();
	}

}
