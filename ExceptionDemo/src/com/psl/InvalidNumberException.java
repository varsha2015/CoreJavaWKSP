package com.psl;

public class InvalidNumberException extends Exception {
	public InvalidNumberException() {
		super(" Number is Invalid ");
	}

	public InvalidNumberException(String message) {
		super(message);
	}

}
