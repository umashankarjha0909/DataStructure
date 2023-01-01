package com.graph.practice;

import java.util.Iterator;
import java.util.LinkedList;

public class EulerCycleCheck {

	private int V;
	private LinkedList<Integer> adj[];
	boolean[] visited = new boolean[V];

	public EulerCycleCheck(int V) {
		this.V = V;
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<>();
			visited[i] = false;
		}
	}

	void DFS(int s) {
		visited[s] = true;
		Iterator<Integer> iterator = adj[s].iterator();
		while (iterator.hasNext()) {
			int next = iterator.next();
			if (!visited[next])
				DFS(next);
		}
	}

	boolean isConnected(int s) {
		int i;
		for (i = 0; i < V; i++) {
			if (adj[i].size() > 0)
				break;
		}

		if (i == V)
			return true;

		DFS(i);
		
		for (i = 0; i < V; i++) {
			if (visited[i] = false && adj[i].size() > 0)
				return false;
		}
		return true;

	}
	
	int isEulerian() {
		
		if (isConnected(0) == false)
            return 0;
		
		int odd = 0;
        for (int i = 0; i < V; i++)
            if (adj[i].size()%2!=0)
                odd++;
        
        if (odd > 2)
            return 0;
        
        return (odd==2)? 1 : 2;
	}
	
	void test()
    {
        int res = isEulerian();
        if (res == 0)
            System.out.println("graph is not Eulerian");
        else if (res == 1)
            System.out.println("graph has a Euler path");
        else
           System.out.println("graph has a Euler cycle");
    }

}
