package com.graph.kruskals.practice;

public class DisjointSet {

	private int parent[];
	private int rank[];

	DisjointSet(int n) {
		parent = new int[n];
		rank = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public int find(int node) {
		if (node == parent[node])
			return node;
		return find(parent[node]);
	}

	public void union(int x, int y) {
		int u = find(x);
		int v = find(y);

		if (u != v) {

			if (rank[u] > rank[v])
				parent[u] = v;
			else if (rank[v] > rank[u])
				parent[v] = u;
			else {
				parent[u] = v;
				rank[u]++;
			}
		}
	}
}
