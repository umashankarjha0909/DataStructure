package com.sorting.practice;

import java.util.LinkedList;
import java.util.Queue;

public class HeapSort {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(15);
		root.right = new Node(5);
		root.left.left = new Node(8);
		root.left.right = new Node(6);
		
		int arr[] = {10,15,5,8,6};
		heapSort(arr);
		
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}

	public static void heapSort(int arr[]) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heapify(arr, i, 0);
		}

	}

	static void heapify(int arr[], int n, int index) {
		int largest = index;
		int left = 2 * index + 1;
		int right = 2 * index + 2;

		if (left < n && arr[left] > arr[largest])
			largest = left;

		if (right < n && arr[right] > arr[largest])
			largest = right;
		if (largest != index) {
			// perform swap
			int temp = arr[index];
			arr[index] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}
	}

	static void print(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node item = queue.poll();
			System.out.println(item.data);
			if (item.left != null)
				queue.add(item.left);
			if (item.right != null)
				queue.add(item.right);
		}
	}
}
