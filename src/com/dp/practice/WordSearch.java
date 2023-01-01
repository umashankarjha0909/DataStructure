package com.dp.practice;

public class WordSearch {

	public static void main(String[] args) {
		char[][] input = { { 'a', 'b', 'c' }, { 'd', 'e', 'a' }, { 'g', 'h', 't' } };
		char[] searchString = "cat".toCharArray();
		if (wordSearch(input, 0, 0, 0, searchString))
			System.out.println("Word Found");
		else
			System.out.println("Word Not Found");
	}

	static boolean isNextMoveSafe(int x, int y, int N) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

	static boolean wordSearch(char[][] input, int row, int column, int count, char[] searchString) {

		if (row == searchString.length - 1 || column == searchString.length - 1)
			return false;
		
		if (count == searchString.length)
			return true;

		if (input[row][column] == searchString[count]) {
			if (checkForRemainingWords(input, row, column, count + 1, searchString))
				return true;
		}

		int x[] = { 0, 0, -1, 1 };
		int y[] = { 1, -1, 0, 0 };
		int next_X = 0;
		int next_Y = 0;
		for (int k = 0; k < x.length; k++) {
			next_X = row + x[k];
			next_Y = column + y[k];
			if (isNextMoveSafe(next_X, next_Y, input.length)) {
				wordSearch(input, next_X, next_Y, count, searchString);
			}
		}

		return false;
	}

	static boolean checkForRemainingWords(char[][] input, int row, int column, int count, char[] searchString) {
		int x[] = { 0, 0, -1, 1 };
		int y[] = { 1, -1, 0, 0 };
		int next_X = 0;
		int next_Y = 0;

		while (count < searchString.length) {
			for (int k = 0; k < x.length; k++) {
				next_X = row + x[k];
				next_Y = column + y[k];
				if (isNextMoveSafe(next_X, next_Y, input.length)) {
					if (input[next_X][next_Y] == searchString[count]) {
						row = next_X;
						column = next_Y;
						count++;
						break;
					}
				}
			}
		}

		if (count == searchString.length)
			return true;
		return false;
	}
}
