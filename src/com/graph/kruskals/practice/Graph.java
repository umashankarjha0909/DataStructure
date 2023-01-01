package com.graph.kruskals.practice;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	int V, E;
	List<Edge> edgeList;

	Graph(int V, int E) {
		this.V = V;
		this.E = E;
		edgeList = new ArrayList<>();
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}
	
	 void addEdge(int u,int v,int weight){
		 edgeList.add(new Edge(u,v,weight));
    }

}
