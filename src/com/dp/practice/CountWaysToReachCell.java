package com.dp.practice;

public class CountWaysToReachCell {

	public static void main(String[] args) {
		char[][] input = { { 'a', 'b', 'c', 'd' }, { 'e', 'f', 'g', 'h' }, { 'i', 'j', 'k', 'l' },
				{ 'm', 'n', 'o', 'p' } };
		Counter counter = new Counter();
		countWays(input, 0, 0, 'j', counter);
		dpSolution(input);
		//System.out.println(counter.value);
	}

	static void countWays(char[][] input, int row, int column, char target, Counter counter) {

		if (row >= input.length || column >= input.length)
			return;

		if (input[row][column] == target) {
			counter.increment();
			return;
		}

		countWays(input, row, column + 1, target, counter);
		countWays(input, row + 1, column, target, counter);

	}

	static void dpSolution(char[][] input) {

		int[][] temp = new int[input.length][input.length];

		for (int i = 0; i < temp.length; i++) {
			temp[0][i] = 1;
			temp[i][0] = 1;
		}

		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp.length; j++) {
				temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
			}
		}

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
