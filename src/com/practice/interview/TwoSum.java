package com.practice.interview;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] input = {1,3,3,4};
		int target = 5;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<input.length;i++) {
			map.put(input[i], i);
		}
		
		int temp = 0;
		Integer element;
		for(int i=0;i<input.length;i++) {
			temp = target-input[i];
			element = map.get(temp);
			if(element!=null) {
				System.out.println(i +" "+ element);
				break;
			}
		}
	}
}
