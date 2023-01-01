package com.practice.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cumulativesum {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 0 }, { 1, 0 }, { 1, 0 }, { 1, 0 } };
		setRowColumnZeroes(matrix);
	}

	static int getdigits(int number) {
		int counter = 1;

		int div = number / 10;
		while (div != 0) {
			div = div / 10;
			counter++;
		}
		return counter;
	}

	static void setRowColumnZeroes(int[][] matrix) {
		List<Pair> pairList = new ArrayList<Pair>();
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		int row = 0;
		int column = 0;
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				if (matrix[i][j] == 0) {
					row = i;
					column = j;
					Pair pair = new Pair(row, column);
					pairList.add(pair);
				}
			}
		}

		for (Pair pair : pairList) {
			row = pair.getRow();
			column = pair.getColumn();
			for (int k = 0; k < columnCount; k++) {
				matrix[row][k] = 0;
			}

			for (int k = 0; k < rowCount; k++) {
				matrix[k][column] = 0;
			}
		}

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void maxOnes(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {

				if (map.get(arr[i]) == null)
					map.put(1, 1);
				else
					map.put(1, map.get(arr[i]));
			} else {
				if (map.get(1) > maxCount)
					maxCount = map.get(1);
				map.put(1, 0);
			}
		}
	}
}
