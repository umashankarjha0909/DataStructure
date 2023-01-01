package com.java.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Collections extends Developer{

	public void addBook(String book) {
		System.out.println("Hello World");
	}
	
	public static void main(String[] args) {
		Collections col = new Collections();
		col.addBook(null);
	}
}
