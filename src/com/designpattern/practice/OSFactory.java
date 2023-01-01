package com.designpattern.practice;

public class OSFactory {

	static OS getInstance(String osType) {
		if (osType.equals("IOS"))
			return new IOS();
		else if (osType.equals("Windows"))
			return new Windows();
		else
			return new Android();
	}
}
