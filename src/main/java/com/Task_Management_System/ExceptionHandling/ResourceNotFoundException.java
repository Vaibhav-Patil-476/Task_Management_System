package com.Task_Management_System.ExceptionHandling;

public class ResourceNotFoundException  extends RuntimeException{

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
