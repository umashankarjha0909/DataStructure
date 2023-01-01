package com.tree.practice;

public class RotatedBinarySearch {

	static int pivotedBinarySearch(int arr[], int n, int key) {
		int pivot = findPivot(arr, 0, n - 1);
		if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);
		if (arr[pivot] == key)
            return pivot;
		if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
	}

	static int findPivot(int arr1[], int low, int high) {
		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (low + high) / 2;

		if (mid < high && arr1[mid] > arr1[mid + 1])
			return mid;

		if (mid > low && arr1[mid] < arr1[mid - 1])
			return mid - 1;

		if (arr1[low] >= arr1[mid])
			return findPivot(arr1, low, mid - 1);
		return findPivot(arr1, mid + 1, high);
	}

	static int binarySearch(int arr1[], int left, int right, int item) {
		int mid = (left + right) / 2;
		if (arr1[mid] == item)
			return mid;
		if (arr1[mid] > item)
			return binarySearch(arr1, left, mid - 1, item);
		else
			return binarySearch(arr1, left + 1, right, item);
	}

	public static void main(String[] args) {
		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int n = arr1.length;
		int key = 3;
		System.out.println(pivotedBinarySearch(arr1,n,key));
	}
}
