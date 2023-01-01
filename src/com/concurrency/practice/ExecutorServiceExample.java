package com.concurrency.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.submit(new Task());
		es.execute(new Task());
		es.execute(new Task());
		es.execute(new Task());
		es.execute(new Task());
		es.shutdown();
	}
}
