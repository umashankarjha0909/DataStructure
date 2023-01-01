package com.graph.practice;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {

	static final int V = 6;

	public boolean bfs(int residual_g[][], int s, int t, int parent[]) {
		boolean visited[] = new boolean[V];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		// Make parent of source -1.
		parent[s] = -1;

		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v = 0; v < V; v++) {
				if (!visited[v] && residual_g[u][v] > 0) {
					visited[v] = true;
					q.add(v);
					parent[v] = u;
					if (v == t)
						return true;
				}
			}
		}
		return false;
	}

	public int Ford_Fulkerson(int graph[][], int s, int t) {
		int residual_g[][] = new int[V][V];
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				residual_g[i][j] = graph[i][j];
		int parent[] = new int[V];
		int max_flow = 0;
		while (bfs(residual_g, s, t, parent)) {
			int flow = Integer.MAX_VALUE;
			for (int v = t; v != s; v = parent[v]) {
				int u = parent[v];
				flow = Math.min(flow, residual_g[u][v]);
			}

			max_flow += flow;

			for (int v = t; v != s; v = parent[v]) {
				int u = parent[v];
				residual_g[u][v] -= flow;
				residual_g[v][u] += flow;
			}
		}
		return max_flow;
	}

	public static void main(String[] args) {

	}
}
