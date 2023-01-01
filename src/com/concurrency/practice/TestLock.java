package com.concurrency.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestLock {

	public static void main(String[] args) {
		final ReentrantLockExample ex = new ReentrantLockExample();

		Runnable task1 = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 200000; i++)
					ex.increment();
			}
		};

		Runnable task2 = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100000; i++)
					ex.increment();
			}
		};

		ExecutorService es = Executors.newFixedThreadPool(2);
		es.submit(task1);
		es.submit(task2);
		try {
			es.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			es.shutdown();
		}
		System.out.println(ex.getCount());
	}
}
