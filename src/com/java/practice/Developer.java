package com.java.practice;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Developer {

	private String name;
	private int age;
	private BigDecimal salary;
	private Set<String> book;
	
	public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
        System.out.println("Hello Developer");
    }
	
	
	
	public Set<String> getBook() {
		return book;
	}



	public void setBook(Set<String> book) {
		this.book = book;
	}



	public Developer() {
		super();
	}



	public Developer(String name, BigDecimal salary, int age) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Developer [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	

}
