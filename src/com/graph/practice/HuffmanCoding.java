package com.graph.practice;

import java.util.PriorityQueue;

public class HuffmanCoding {

	
	public static void printCode(HuffmanNode root, String s) {
		if(root.left==null && root.right==null && Character.isLetter(root.c)) {
			System.out.println(root.c + ":" +s);
			return;
		}
		printCode(root.left,s+"0");
		printCode(root.right, s+"1");
	}
	
	// Create priority queue
	// Create Huffman nodes
	// Create TreeNodes
	// Print the Tree along with codes
	
	public static void main(String[] args) {
		
		int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>(n, new HuffmanCodeComparator());
        
        for (int i = 0; i < n; i++) {
        	 
            HuffmanNode hn = new HuffmanNode();
 
            hn.c = charArray[i];
            hn.data = charfreq[i];
 
            hn.left = null;
            hn.right = null;
 
           
            queue.add(hn);
        }
        
        HuffmanNode root = null;
        
        while(queue.size()>1) {
        	HuffmanNode node1 = queue.peek();
        	queue.poll();
        	HuffmanNode node2 = queue.peek();
        	queue.poll();
        	
        	HuffmanNode newNode = new HuffmanNode();
        	newNode.data = node1.data + node2.data;
        	newNode.c = '-';
        	
        	newNode.left = node1;
        	newNode.right = node2;
        	root = newNode;
        	queue.add(newNode);
        }
        printCode(root,"");
	}
	
}
