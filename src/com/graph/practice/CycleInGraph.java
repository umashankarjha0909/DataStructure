package com.graph.practice;

public class CycleInGraph {

	static class Graph {
		int V, E;
		Edge[] edge;

		Graph(int nV, int nE) {
			V = nV;
			E = nE;
			edge = new Edge[E];
			for (int i = 0; i < E; i++) {
				edge[i] = new Edge();
			}
		}
	}

	static class Edge {
		int src, dest;
	}

	static class Subset {
		int parent = 0;
		int rank = 0;
	}

	static int find(Subset[] subset, int i) {
		if (subset[i].parent == i)
			return i;
		return find(subset, subset[i].parent);
	}

	static void union(Subset[] subset, int x, int y) {
		int xroot = find(subset, x);
		int yroot = find(subset, y);

		if (subset[xroot].rank < subset[yroot].rank)
			subset[xroot].parent = yroot;
		else if (subset[yroot].rank < subset[xroot].rank)
			subset[yroot].parent = xroot;
		else {
			subset[xroot].parent = yroot;
			subset[yroot].rank++;
		}

	}

	static int isCycle(Graph graph) {
		int V = graph.V;
		int E = graph.E;
		Subset[] subset = new Subset[V];
		for (int v = 0; v < V; v++) {

			subset[v] = new Subset();
			subset[v].parent = v;
			subset[v].rank = 0;
		}
		for (int i = 0; i < V; i++) {
			int x = find(subset, graph.edge[i].src);
			int y = find(subset, graph.edge[i].dest);
			if (x == y)
				return 1;
			union(subset, x, y);
		}
		return 0;
	}

	public static void main(String[] args) {
		int V = 3, E = 3;
		Graph graph = new Graph(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;

		// add edge 1-2
		graph.edge[1].src = 1;
		graph.edge[1].dest = 2;

		// add edge 0-2
		graph.edge[2].src = 0;
		graph.edge[2].dest = 2;

		if (isCycle(graph) == 1)
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}
}
