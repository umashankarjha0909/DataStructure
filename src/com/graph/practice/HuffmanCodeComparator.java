package com.graph.practice;

import java.util.Comparator;

public class HuffmanCodeComparator implements Comparator<HuffmanNode>{

	@Override
	public int compare(HuffmanNode x, HuffmanNode y) {
		 return x.data - y.data;
	}

}
