package com.dp.practice;

public class MinimumCostPath {

	public static void main(String[] args) {
		int[][] cost = { { 1, 7, 9, 2 }, { 8, 6, 3, 2 }, { 1, 6, 7, 8 }, { 2, 9, 8, 2 } };

		int N = 4, M = 4;

		// Declare the auxiliary minCost matrix
		int[][] minCost = new int[M][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				minCost[i][j] = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int currCost = Integer.MAX_VALUE;

				if (i - 1 >= 0)
					currCost = Math.min(currCost, minCost[i - 1][j]);

				if (j - 1 >= 0)
					currCost = Math.min(currCost, minCost[i][j - 1]);

				if (currCost == Integer.MAX_VALUE){
					minCost[i][j] = cost[i][j];
					continue;
				}

				minCost[i][j] = currCost + cost[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(minCost[i][j]+" ");
			}
			System.out.println();
		}

	}
}
