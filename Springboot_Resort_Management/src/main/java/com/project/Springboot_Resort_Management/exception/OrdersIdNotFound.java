package com.project.Springboot_Resort_Management.exception;

public class OrdersIdNotFound extends RuntimeException{

	private String message="Orders id not found in the database";

	public String getMessage() {
		return message;
	}
	
}
