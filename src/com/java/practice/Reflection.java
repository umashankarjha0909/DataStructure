package com.java.practice;

import java.lang.reflect.Constructor;

public class Reflection {

	public static void main(String[] args) {
		Singleton instance1 = Singleton.instance;
		Singleton instance2 = null;

		try {
			Constructor[] constructors = Singleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				constructor.setAccessible(true);
				instance2 = (Singleton) constructor.newInstance();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("instance1.hashCode():- " + instance1.hashCode());
		System.out.println("instance2.hashCode():- " + instance2.hashCode());
	}
}
