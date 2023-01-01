package com.graph.practice;

public class Dijkstra {

	public void dijkstra(int graph[][], int source) {
		int noOfVertices = graph.length;
		int[] weight = new int[noOfVertices];
		weight[source] = 0;
		int weightTmp;
		
		for(int k=1;k<noOfVertices;k++) {
			for(int i=0;i<noOfVertices;i++) {
				if(graph[k][i] > 0) {
					weightTmp = graph[i][k] + weight[k];
					if(weight[k]>weightTmp)
						weight[k] = weightTmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
	    int graph[][] = new int[][] { { 0, 0, 1, 2, 0, 0, 0 }, { 0, 0, 2, 0, 0, 3, 0 }, { 1, 2, 0, 1, 3, 0, 0 },
	        { 2, 0, 1, 0, 0, 0, 1 }, { 0, 0, 3, 0, 0, 2, 0 }, { 0, 3, 0, 0, 2, 0, 1 }, { 0, 0, 0, 1, 0, 1, 0 } };
	    Dijkstra T = new Dijkstra();
	    T.dijkstra(graph, 0);
	  }
}
