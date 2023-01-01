package com.test.practice;

public class OnceAppearElement {

	public static void main(String[] args) {
		int arr[] = { 3, 3, 2, 3 };
        int n = arr.length;
        
        System.out.println(~1);
        //System.out.println("The element with single occurrence is " + getSingle(arr, n));
    
	}
	
	static int getSingle(int arr[], int n) {
		int ones = 0, twos = 0;
        int common_bit_mask;
        
        for (int i = 0; i < n; i++) {
        	twos = twos | (ones & arr[i]);
        	ones = ones ^ arr[i];
        	common_bit_mask = ~(ones & twos);
        	ones &= common_bit_mask;
        	twos &= common_bit_mask;
        }
        return ones;
	}
}
