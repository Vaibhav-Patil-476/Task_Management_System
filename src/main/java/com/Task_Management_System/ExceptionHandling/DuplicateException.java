package com.Task_Management_System.ExceptionHandling;

public class DuplicateException extends RuntimeException {

	public DuplicateException(String message) {
		super(message);
	}
}