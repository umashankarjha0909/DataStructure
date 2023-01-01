package com.graph.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	private LinkedList<Integer> adjList[];
	private boolean visited[];

	// Graph Creation
	public Graph(int vertices) {
		adjList = new LinkedList[vertices];
		visited = new boolean[vertices];

		for (int i = 0; i < vertices; i++) {
			adjList[i] = new LinkedList<>();
			visited[i] = false;
		}
	}

	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
		adjList[dest].add(src);
	}

	
	public void DFS(int source) {
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		while (!stack.isEmpty()) {
			Integer temp = stack.pop();
			visited[temp] = true;
			System.out.println("Visited " + temp);
			Iterator<Integer> ite = adjList[temp].listIterator();
			while (ite.hasNext()) {
				Integer nextElement = ite.next();
				if(!visited[nextElement]) {
					stack.add(nextElement);
					visited[nextElement] = true;
				}
			}
		}
	}

	public void BFS(int source) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		while(!queue.isEmpty()) {
			Integer temp = queue.poll();
			visited[temp] = true;
			System.out.println("Visited " + temp);
			Iterator<Integer> ite = adjList[temp].listIterator();
			while (ite.hasNext()) {
				Integer nextElement = ite.next();
				if(!visited[nextElement]) {
					queue.add(nextElement);
					visited[nextElement] = true;
				}
			}
		}
	}
	
	public void detectCycle(int source) {
		visited[source] = true;
		Iterator<Integer> iterator = adjList[source].iterator();
		while(iterator.hasNext()) {
			int next = iterator.next();
			if(!visited[next]) {
				detectCycle(next);
			}
			if(visited[next]) {
				System.out.println("Cycle is detected at " +next);
			}
		}
	}
	
	public static void main(String[] args) {
		/*Graph g = new Graph(7);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 5);
		g.addEdge(2, 4);
		g.addEdge(4, 6);*/

		//System.out.println("Following is Depth First Traversal");

		//g.DFS(0);
		//g.BFS(0);
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.BFS(0);
		
	}
}
