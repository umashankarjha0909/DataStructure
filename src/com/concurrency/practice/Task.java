package com.concurrency.practice;


public class Task implements Runnable{

	@Override
	public void run() {
		System.out.println("Executing Task1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
