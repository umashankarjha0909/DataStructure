package com.practice.interview;

public class KthLargest {

	public static void main(String[] args) {
		int[] arr = { 4, 1, 6, 5, 3 };
		quickSort(arr,0,arr.length-1);
		for(int j=0;j<arr.length;j++)
			System.out.println(arr[j]);
	}

	static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

	
	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1;
		
		for(int j=low;j<high;j++) {
			if(arr[j]>pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return i+1;
	}

	static void quickSort(int arr[], int left, int right) {
		if (left < right) {
			int index = partition(arr, left, right);
			quickSort(arr, left, index - 1);
			quickSort(arr, index + 1, right);
		}
	}

	public static int kthSmallest(int[] arr, int l, int r, int K) {
		if (K > 0 && K <= r - l + 1) {
			int pos = partition(arr, l, r);
			if (pos - 1 == K - 1)
				return arr[pos];

			if (pos - l > K - 1)
				return kthSmallest(arr, l, pos - 1, K);

			return kthSmallest(arr, pos + 1, r, K - pos + l - 1);
		}
		return Integer.MAX_VALUE;
	}
}
