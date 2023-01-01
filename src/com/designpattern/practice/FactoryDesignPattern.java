package com.designpattern.practice;

public class FactoryDesignPattern {

	// We have interface and multiple implementation of that object. so depend on requirement object is created at runtime
	
	public static void main(String[] args) {
		OS obj = OSFactory.getInstance("Windows");
		obj.spec(); 
	}
}
