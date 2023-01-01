package com.graph.kruskals.practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MSTKruskal {

	public static void main(String[] args) {
		Graph g = new Graph(6, 9);
		g.addEdge(0, 1, 7);
		g.addEdge(0, 2, 8);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 4, 6);
		g.addEdge(2, 3, 3);
		g.addEdge(2, 4, 4);
		g.addEdge(3, 4, 2);
		g.addEdge(3, 5, 2);
		g.addEdge(4, 5, 2);
		MST_Kruskal(g);
	}

	static void MST_Kruskal(Graph graph) {
		List<Edge> edgeList = graph.getEdgeList();
		int e = 0, i = 0, sum = 0;
		DisjointSet dsu = new DisjointSet(graph.V);
		Collections.sort(graph.edgeList, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
		});

		while (e < graph.V - 1) {
			Edge edge = edgeList.get(i++);
			int u = dsu.find(edge.u);
			int v = dsu.find(edge.v);

			if (u != v) {
				System.out.println("Adding edge " + edge.u + " <---> " + edge.v + " to MST");
				sum += edge.weight;
				dsu.union(u, v);
				e++;
			}
		}
		System.out.println("MST has a weight of " + sum);
	}
}
