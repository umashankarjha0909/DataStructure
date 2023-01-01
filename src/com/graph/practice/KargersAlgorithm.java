package com.graph.practice;

import java.util.Random;

public class KargersAlgorithm {

	static int V, E;
	static int parent[];
	static int rank[];

	static Random rand;

	KargersAlgorithm(int V, int E) {
		this.V = V;
		this.E = E;
		parent = new int[V];
		rank = new int[V];
		rand = new Random();

		for (int i = 0; i < V; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public static void main(String[] args) {
		int V = 5, E = 7;
		KargersAlgorithm ka = new KargersAlgorithm(V, E);
		Edge edge[] = new Edge[E];

		edge[0] = new Edge(0, 3);
		edge[1] = new Edge(3, 2);
		edge[2] = new Edge(2, 1);
		edge[3] = new Edge(1, 0);
		edge[4] = new Edge(0, 2);
		edge[5] = new Edge(2, 4);
		edge[6] = new Edge(4, 1);
		System.out.println("Count of edges needs to be removed " + ka.minCutKarger(edge));

	}

	static int minCutKarger(Edge edges[]) {
		int vertices = V;
		while (vertices > 2) {
			int i = rand.nextInt(E);
			int set1 = find(edges[i].u);
			int set2 = find(edges[i].v);
			if (set1 != set2) {
				System.out.println("Contracting vertices " + edges[i].u + " and " + edges[i].v);
				// Merging vertices u and v into one.
				union(edges[i].u, edges[i].v);
				// Reducing count of vertices by 1.
				vertices--;
			}
		}
		System.out.println("Edges needs to be removed - ");
		int ans = 0;
		for (int i = 0; i < E; i++) {
			// Finding leader element to which
			// edges[i].u belongs.
			int set1 = find(edges[i].u);
			// Finding leader element to which
			// edges[i].v belongs.
			int set2 = find(edges[i].v);

			// If they are not in the same set.
			if (set1 != set2) {
				System.out.println(edges[i].u + " <----> " + edges[i].v);
				// Increasing the ans.
				ans++;
			}
		}
		return ans;
	}

	public static int find(int node) {

		// If the node is the parent of
		// itself then it is the leader
		// of the tree.
		if (node == parent[node])
			return node;

		// Else, finding parent and also
		// compressing the paths.
		return parent[node] = find(parent[node]);
	}

	static void union(int u, int v) {

		// Make u as a leader
		// of its tree.
		u = find(u);

		// Make v as a leader
		// of its tree.
		v = find(v);

		// If u and v are not equal,
		// because if they are equal then
		// it means they are already in
		// same tree and it does not make
		// sense to perform union operation.
		if (u != v) {
			// Checking tree with
			// smaller depth/height.
			if (rank[u] < rank[v]) {
				int temp = u;
				u = v;
				v = temp;
			}
			// Attaching lower rank tree
			// to the higher one.
			parent[v] = u;

			// If now ranks are equal
			// increasing rank of u.
			if (rank[u] == rank[v])
				rank[u]++;
		}
	}

	static class Edge {
		// Endpoints u and v
		// of the Edge e.
		int u;
		int v;

		// Constructor for
		// Initializing values.
		Edge(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}

}
