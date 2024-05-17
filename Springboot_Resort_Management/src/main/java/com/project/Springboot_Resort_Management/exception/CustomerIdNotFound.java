package com.project.Springboot_Resort_Management.exception;

public class CustomerIdNotFound extends RuntimeException{

	private String message="Customer id not found in the database";

	public String getMessage() {
		return message;
	}
	
}
