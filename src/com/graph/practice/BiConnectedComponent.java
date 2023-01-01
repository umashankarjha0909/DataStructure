package com.graph.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BiConnectedComponent {

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int time;
	static boolean visited[];
	static int par[], disc[], low[];

	static List<List<Integer>> adj;

	static void addEgde(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	static boolean isEqual(Pair p1, Pair p2) {
		return p1.x == p2.x && p1.y == p2.y;
	}

	static void printStackTill_UV(Stack<Pair> st, Pair p) {
		while (!st.isEmpty()) {
			System.out.print(st.peek().x + " - " + st.peek().y + "   ");
			if (isEqual(st.peek(), p)) {
				st.pop();
				break;
			}
			st.pop();
		}
		System.out.println();
	}

	static void printBiConnectedComponents(int n) {
		time = 1;
		low = new int[n + 1];
		visited = new boolean[n + 1];
		disc = new int[n + 1];
		par = new int[n + 1];
		Arrays.fill(par, -1);

		for (int i = 1; i <= n; i++) {

			// If the current node is not previously visited
			if (!visited[i]) {
				// Stack of edges
				Stack<Pair> st = new Stack<>();
				// Call DFS
				DFS(i, st);

				// Print the stack when DFS call returns
				while (!st.isEmpty()) {
					System.out.print(st.peek().x + " - " + st.pop().y + "   ");
				}
			}
		}

	}

	static void DFS(int src, Stack<Pair> st) {
		disc[src] = low[src] = time++;
		visited[src] = true;
		int child = 0;
		for (int nbr : adj.get(src)) {
			Pair edge = new Pair(src, nbr);
			if (!visited[nbr]) {
				child++;
				par[nbr] = src;
				st.push(edge);

				DFS(nbr, st);

				low[src] = Math.min(low[src], low[nbr]);

				// Check for Articulation point, if it's true
				// then print all edges
				if ((par[src] == -1 && child > 1) || (par[src] != -1 && low[nbr] >= disc[src]))
					printStackTill_UV(st, edge);
			} else if (par[src] != nbr && disc[nbr] < low[src]) {
				// if the neighbour is previously visited
				// Update the low value.
				low[src] = disc[nbr];
				// Push edge to stack.
				st.push(edge);
			}
		}

	}

	public static void main(String[] args) {
		adj = new ArrayList<>();
		int V = 6;
		for (int i = 0; i <= V; i++)
			adj.add(new ArrayList<>());

		addEgde(1, 4);
		addEgde(1, 3);
		addEgde(4, 2);
		addEgde(3, 2);
		addEgde(2, 5);
		addEgde(2, 6);
		addEgde(5, 6);
		printBiConnectedComponents(V);
		System.out.println();
	}
}
