package com.java.practice;

public class NGE {

	public static void main(String[] args) {
		int arr[] = { 5,4,3,2,1,6 };
		int n = arr.length;
		printNGE(arr, n);
	}

	static class stack {
		int top;
		int items[] = new int[100];

		void push(int x) {
			if (top == 99) {
				System.out.println("Stack full");
			} else {
				items[++top] = x;
			}
		}

		int pop() {
			if (top == -1) {
				System.out.println("Underflow error");
				return -1;
			} else {
				int element = items[top];
				top--;
				return element;
			}
		}

		boolean isEmpty() {
			return (top == -1) ? true : false;
		}
	}

	static void printNGE(int arr[], int n) {
		int i = 0;
		stack s = new stack();
		s.top = -1;
		int previousElement, next;
		s.push(arr[0]);
		for (i = 1; i < n; i++) {
			next = arr[i];
			if (s.isEmpty() == false) {
				previousElement = s.pop();

				while (previousElement < next) {
					System.out.println(previousElement + " --> " + next);
					if (s.isEmpty() == true)
						break;
					previousElement = s.pop();
				}

				if (previousElement > next)
					s.push(previousElement);
			}

			s.push(next);
		}

		while (s.isEmpty() == false) {
			previousElement = s.pop();
			next = -1;
			System.out.println(previousElement + " -- " + next);
		}
	}
}
