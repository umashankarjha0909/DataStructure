package com.designpattern.practice;

public class AdapterDesignPattern {

	public static void main(String[] args) {
		Pen p = new PenAdapter();
		AssignmentWork aw = new AssignmentWork();
		aw.setPen(p);
		aw.writeAssignment("Hello World");
	}
}
