package com.test.practice;

public class ConvertNumberToWord {

	public static void main(String[] args) {
		//convert_to_words("3".toCharArray());
		
		int arr[]= {0 , 2,  1, 2, 0};
		sort(arr);
		
	}
	
	static void sort(int a[]) {
		
		StringBuilder result = new StringBuilder();
		int count0 = 0;
		int count1 = 0;
		int count2 =0;
		
		for(int i=0;i<a.length;i++) {
			if(a[i] == 0) {
				count0++;
			}
		}
		
		for(int i=0;i<a.length;i++) {
			if(a[i] == 1) {
				count1++;
			}
		}
		
		for(int i=0;i<a.length;i++) {
			if(a[i] == 2) {
				count2++;
			}
		}
		
		while(count0 > 0) {
			result.append("0");
			count0--;
		}
		
		while(count1 > 0) {
			result.append("1");
			count1--;
		}
		
		while(count2 > 0) {
			result.append("2");
			count2--;
		}
		
		System.out.println(result.toString());
	}
	
	
	static void convert_to_words(char[] num) {
		
		int len = num.length;
		
		if (len == 0) {
            System.out.println("empty string");
            return;
        }
		
		if (len > 4) {
            System.out.println("Length more than 4 is not supported");
            return;
        }
		
		String[] single_digits = new String[] {"zero", "one", "two",   "three", "four","five", "six", "seven", "eight", 
				"nine"};
		
		String[] two_digits = new String[] {
	            "",          "ten",      "eleven",  "twelve","thirteen",  "fourteen", "fifteen", "sixteen","seventeen", 
	            "eighteen", "nineteen"};
		
		String[] tens_multiple = new String[] {
	            "",      "",      "twenty",  "thirty", "forty",
	            "fifty", "sixty", "seventy", "eighty", "ninety"
	        };
		
		String[] tens_power = new String[] { "hundred", "thousand" };
		
		if (len == 1) {
            System.out.println(single_digits[num[0] - '0']);
            return;
        }
	}
	
	
}
