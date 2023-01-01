package com.designpattern.practice;

public class BuilderDesignPattern {

	// This pattern is used to build the object. we may not know all the attributes
	// to build the object at object creation
	// time so there needs to be a way to create plain object and set attributes
	// later

	public static void main(String[] args) {
		Phone phone = new PhoneBuilder().setRam(2).setBattery(220).build();
		System.out.println(phone);
	}
}
