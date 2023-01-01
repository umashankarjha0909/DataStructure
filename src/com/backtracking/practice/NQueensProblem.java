package com.backtracking.practice;

public class NQueensProblem {

	public static void main(String[] args) {

		int[][] board = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		NQueensProblem nqp = new NQueensProblem();
		nqp.solveNQueen(board, 0);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

	boolean isSafeToPlace(int[][] board, int row, int col) {

		// check if it can be placed on left side
		for (int i = 0; i < col; i++) {
			if (board[row][i] == 1)
				return false;
		}

		// check if it can be placed on upper diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}

		// check if it can be placed on lower diagonal
		for (int i = row, j = col; j >= 0 && i < board.length; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}
		return true;

	}

	boolean solveNQueen(int board[][], int col) {

		if (col >= board.length)
			return true;

		for (int i = 0; i < board.length; i++) {
			if (isSafeToPlace(board, i, col)) {
				board[i][col] = 1;

				if (solveNQueen(board, col + 1))
					return true;

				board[i][col] = 0;
			}
		}
		return false;
	}
}
