package com.concurrency.practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	private final Lock lock = new ReentrantLock();

	private int count = 0;

	public void increment() {
		lock.lock();
		try {
			count = count + 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (lock != null)
				lock.unlock();
		}
	}
	
	public int getCount() {
		return count;
	}

}
