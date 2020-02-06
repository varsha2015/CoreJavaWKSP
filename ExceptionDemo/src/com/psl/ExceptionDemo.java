package com.psl;

import java.io.FileNotFoundException;
import java.io.IOException;

class A {
	public void show()throws IOException {

	}
}

class B extends A {
	public void show()throws FileNotFoundException {

	}
}

public class ExceptionDemo {
	private int div(int x, int y) throws InvalidNumberException {
		if (y == 0)
			throw new InvalidNumberException();
		return x / y;
	}

	private int add(int x, int y) {
		return x + y;
	}

	public int calculate(int i, int j, int operation) throws Exception {
		int x = 0;
		if (operation == 1) {
			x = add(i, j);
			// System.out.println(" Addition :"+x);
		}
		if (operation == 2) {
			x = div(i, j);
			// System.out.println(" Division :"+x);
		}
		return x;
	}

	public static void main(String[] args) throws Exception {
		ExceptionDemo demo = new ExceptionDemo();
		try {
			System.out.println("Result :" + demo.calculate(10, 20, 2));
			// System.out.println("Result :"+demo.calculate(5, 0, 2));
			System.out.println(" This is next line in Try block............");
			try {
				throw new Exception(" My Exception");
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println("log messages......");
			e.printStackTrace();
			throw e;
		} 
		 catch (Throwable e) {
				System.out.println(e);
			} 
		finally {
			int r = 90;
			System.out.println(" I am in finally block.....");
		}
		System.out.println(" This is next line in my program............");

	}
}
