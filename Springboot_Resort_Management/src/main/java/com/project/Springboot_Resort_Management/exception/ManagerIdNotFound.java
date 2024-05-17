package com.project.Springboot_Resort_Management.exception;

public class ManagerIdNotFound extends RuntimeException{
	
	private String message="Manager id not found in database";

	public String getMessage() {
		return message;
	}

}
