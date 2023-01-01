package com.graph.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedComponent {

	private int V;
	private LinkedList<Integer> adj[];

	StronglyConnectedComponent(int s) {
		V = s;
		adj = new LinkedList[s];
		for (int i = 0; i < s; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int s, int d) {
		adj[s].add(d);
	}

	void fillOrder(int s, boolean visitedVertices[], Stack<Integer> stack) {
		visitedVertices[s] = true;
		Iterator<Integer> itr = adj[s].iterator();
		while (itr.hasNext()) {
			int next = itr.next();
			if (!visitedVertices[next])
				fillOrder(next, visitedVertices, stack);
		}
		stack.push(s);
	}

	StronglyConnectedComponent Transpose() {
		StronglyConnectedComponent g = new StronglyConnectedComponent(V);
		for (int s = 0; s < V; s++) {
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext())
				g.adj[i.next()].add(s);
		}
		return g;
	}
	
	// DFS
		void DFSUtil(int s, boolean visitedVertices[]) {
			visitedVertices[s] = true;
			System.out.print(s + " ");
			int n;

			Iterator<Integer> i = adj[s].iterator();
			while (i.hasNext()) {
				n = i.next();
				if (!visitedVertices[n])
					DFSUtil(n, visitedVertices);
			}
		}
	
	void printSCC() {
		Stack<Integer> stack = new Stack<Integer>();

		boolean visitedVertices[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visitedVertices[i] = false;
		fillOrder(0,visitedVertices,stack);
		//stack.forEach(System.out::println);
		
		StronglyConnectedComponent gr = Transpose();
		
		for (int i = 0; i < V; i++)
			visitedVertices[i] = false;
		
		while(!stack.isEmpty()) {
			int s = stack.pop();
			if(visitedVertices[s]==false) {
				gr.DFSUtil(s, visitedVertices);
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		StronglyConnectedComponent g = new StronglyConnectedComponent(8);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 0);
		g.addEdge(4, 5);
		g.addEdge(5, 6);
		g.addEdge(6, 4);
		g.addEdge(6, 7);
		g.printSCC();
	}

}
