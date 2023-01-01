package com.graph.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StronglyConnectedComponents {

	static int time = 0;
	static List<List<Integer>> adj;
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
		criticalConnections(V,adj);
	}

	static void addEgde(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	private static void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
		disc[u] = low[u] = ++time;
		for (int j = 0; j < graph[u].size(); j++) {
			int v = graph[u].get(j);
			if (v == pre) {
				continue; // if parent vertex, ignore
			}
			if(disc[v]==-1) {
				dfs(v, low, disc, graph, res, u);
				low[u] = Math.min(low[u], low[v]);
				if (low[v] > disc[u]) {
					// u - v is critical, there is no path for v to reach back to u or previous vertices of u
					res.add(Arrays.asList(u, v));
				}
			}else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}

	public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		int[] disc = new int[n], low = new int[n];
		List<Integer>[] graph = new ArrayList[n];
		List<List<Integer>> res = new ArrayList<>();

		Arrays.fill(disc, -1);

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		// build graph
		for (int i = 0; i < connections.size(); i++) {
			int from = connections.get(i).get(0), to = connections.get(i).get(1);
			graph[from].add(to);
			graph[to].add(from);
		}

		return null;
	}

}
