package com.graph.practice;

public class UnionFind {

	private int parent[];
	private int rank[];

	UnionFind(int n) {
		parent = new int[n];
		rank = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

	}

	public int find(int node) {
		if (parent[node] == node)
			return node;
		return parent[node] = find(parent[node]);
	}

	public void union(int u, int v) {
		u = find(u);
		v = find(v);
		if (u != v) {
			if (rank[u] < rank[v]) {
				int temp = u;
				u = v;
				v = temp;
			}

			parent[v] = u;
			if (rank[u] == rank[v])
				rank[u]++;
		}
	}
	
	public static void main(String[] args) {
		UnionFind unionFind = new UnionFind(5);
		
		unionFind.union(1,2);
	}
}
