package com.practice.interview;

public class InsertionSort {

	public static void main(String[] args) {
		int A[] = {5, 4, 2, 5, 3, 1};
		int start=0;
		int end = A.length;
		
	}
	
	static void getInversionCount(int[] arr) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j])
					count++;
			}
		}
	}

	static void mergesort(int[] A, int start,int end) {
		
		if(start<end) {
			int mid = start+(end-start)/2;
			mergesort(A,start,mid);
			mergesort(A,mid+1,end);
			merge(A,start,mid,end);
		}
	}
	static void merge(int[] A, int l, int m, int r) {
		
		int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = A[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = A[m + 1 + j];
        
        
		int left = 0;
		int right = 0;
		int[] C = new int[L.length + R.length];
		int counter=0;
		while (left < L.length && right < R.length) {
			if(L[left] >= R[right]) {
				C[counter]=R[right];
				right++;
			} else {
				C[counter]=L[left];
				left++;
			}
			counter++;
		}
		
		for(int i=left;i<L.length;i++)
			C[counter++]=L[i];
		
		for(int i=right;i<R.length;i++)
			C[counter++]=R[i];
		
		for(int i=0;i<C.length;i++)
			System.out.println(C[i]);
	}
}
