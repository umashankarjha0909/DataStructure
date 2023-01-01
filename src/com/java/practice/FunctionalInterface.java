package com.java.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FunctionalInterface {

	public static void main(String[] args) {
		Java8Consumer1();
	}

	static void Java8UnaryOperator1() {

		Function<Integer, Integer> func = x -> x * 2;
		Integer result = func.apply(2);
		System.out.println(result);

		UnaryOperator<Integer> unaryOps = x -> x * 4;
		System.out.println(unaryOps.apply(4));
		// UnaryOPAsArgument(unaryOps);
	}

	static void UnaryOPAsArgument(UnaryOperator<Integer> unaryOps) {
		System.out.println(unaryOps.apply(5));
	}

	static void Java8BinaryOperator1() {
		BiFunction<Integer, Integer, Integer> func = (x1, x2) -> (x1 + x2);
		System.out.println(func.apply(2, 3));

		BinaryOperator<Integer> binaryOps = (x1, x2) -> (x1 * x2);
		System.out.println(binaryOps.apply(2, 3));
	}

	static void Java8Predicate() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Predicate<Integer> numGreaterThanFive = x -> x > 5 && x < 8;
		list.stream().filter(numGreaterThanFive).forEach(System.out::println);
	}
	
	static void Java8Consumer1() {
		Consumer<String> print = System.out::println;
		print.accept("hello");
	}

}
