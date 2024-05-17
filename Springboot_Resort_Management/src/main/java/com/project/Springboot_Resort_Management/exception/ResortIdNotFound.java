package com.project.Springboot_Resort_Management.exception;

public class ResortIdNotFound extends RuntimeException{

	private String message="Resort id not found in the database";

	public String getMessage() {
		return message;
	}
	
}
