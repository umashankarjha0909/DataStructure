package com.backtracking.practice;

public class RatMaze {

	static int N=4;
	
	public static void main(String[] args) {
		solveRatMazeUtil();
	}
	
	static boolean isSafe(int[][] arr,int row, int col) {
		return (row>=0 && row<N && col>=0 && col<N && arr[row][col]==1);
	}
	
	static void printSolution(int sol[][]){
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(sol[x][y] + " ");
            }
            System.out.println();
        }
    }
	
	static boolean solveRatMazeUtil() {
		int xmove[] = {0,1};
		int ymove[] = {1,0};
		
		int arr[][] = {{1, 0, 0, 0},{1, 1, 0, 1},{0, 1, 0, 0},{1, 1, 1, 1}};
		arr[0][0] = 2;
		solveRatMaze(arr,0,0,xmove,ymove);
		printSolution(arr);
		return true;
	}
	
	static boolean solveRatMaze(int arr[][],int x,int y, int[] xmove,int[] ymove) {
		
		int x_next = 0;
		int y_next=0;
		int k;
		for(k=0;k<2;k++) {
			x_next = x + xmove[k];
			y_next = y + ymove[k];
			if(isSafe(arr,x_next,y_next)) {
				arr[x_next][y_next] = 2;
				if(solveRatMaze(arr,x_next,y_next,xmove,ymove))
					return true;
			}
		}
		return false;
	}
}
