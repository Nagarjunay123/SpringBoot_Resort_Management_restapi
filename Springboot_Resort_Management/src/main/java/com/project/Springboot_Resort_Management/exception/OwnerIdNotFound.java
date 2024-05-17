package com.project.Springboot_Resort_Management.exception;

public class OwnerIdNotFound extends RuntimeException{

	private String message="Owner Id not Found in the database";

	public String getMessage() {
		return message;
	}
	
}
