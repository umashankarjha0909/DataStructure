package com.java.practice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {

		/*
		 * List<Developer> developerList = getDevelopers();
		 * 
		 * Collections.sort(developerList, (Developer o1, Developer o2) -> o1.getAge() -
		 * o2.getAge());
		 * 
		 * Consumer<Developer> devConsumer = (developer) ->
		 * System.out.println(developer);
		 * 
		 * developerList.stream().forEach(x -> devConsumer.accept(x));
		 */

		Developer o1 = new Developer();
		o1.setName("mkyong");
		o1.addBook("Java 8 in Action");
		o1.addBook("Spring Boot in Action");
		o1.addBook("Effective Java (3nd Edition)");

		Developer o2 = new Developer();
		o2.setName("zilap");
		o2.addBook("Learning Python, 5th Edition");
		o2.addBook("Effective Java (3nd Edition)");

		List<Developer> list = new ArrayList<>();
		list.add(o1);
		list.add(o2);

		Set<String> collect = list.stream().map(x -> x.getBook()).flatMap(x -> x.stream())
				.filter(x -> !x.toLowerCase().contains("python")).collect(Collectors.toSet());

		// collect.stream().forEach(System.out::println);
		FlatMapExample2();
	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));

		return result;

	}

	static void convertToFlatMap() {
		String[][] array = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
		// Stream.of(array).flatMap(Stream::of).forEach(x -> System.out.println(x));
		Stream.of(array).flatMap(Stream::of).filter(x -> !"a".equals(x)).forEach(x -> System.out.println(x));
	}

	static void FlatMapExample2() {

		List<Order> orders = findAll();
		BigDecimal sumOfLineItems = orders.stream().flatMap(x -> x.getLineItems().stream()).map(x -> x.getTotal())
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		BigDecimal sumOfOrder = orders.stream().map(x -> x.getTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);

		System.out.println(sumOfLineItems); // 3194.20
		System.out.println(sumOfOrder);

		List<String> stringList = Arrays.asList("hello world Java", "hello world Python", "hello world Node JS",
				"hello world Rust");

	}

	private static List<Order> findAll() {

		LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal("1.20"), new BigDecimal("1.20"));
		LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
		Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

		LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
		LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
		Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

		LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
		Order order3 = new Order(3, "A0000003", Arrays.asList(item5), new BigDecimal("1497.00"));

		return Arrays.asList(order1, order2, order3);

	}
}
