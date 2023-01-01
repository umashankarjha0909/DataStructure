package com.test.practice;

public class DrawCircle {

	
	static void drawCircle(int r) {
		int N = 2*r+1;
		int x,y;
		
		for (int i = 0; i < N; i++)
	    {
	        for (int j = 0; j < N; j++)
	        {
	        	x = i-r;
	            y = j-r;
	        	if(x*x + y*y <= r*r+1)
	        		System.out.print(".");
	        	else
	        		System.out.print(" ");
	        	System.out.print(" ");
	        }
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		drawCircle(12);
	}
}
