package com.tree.practice;

public class CelebrityProblem {

	static int MATRIX[][] = { { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 } };
	
	static int knows(int a, int b) { return MATRIX[a][b]; }
	
	static int findCelebrity(int n) {
		int[] indegree = new int[n];
        int[] outdegree = new int[n];
		for(int i=0;i<MATRIX.length;i++) {
			for(int j=0;j<MATRIX.length;j++) {
				int x = knows(i,j);
				outdegree[i]+=x;
				indegree[j]+=x;
			}
		}
		for(int k=0;k<n;k++) {
			if(indegree[k]==n-1 && outdegree[k]==0)
				return k;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		System.out.println(findCelebrity(4));
		
	}
}
