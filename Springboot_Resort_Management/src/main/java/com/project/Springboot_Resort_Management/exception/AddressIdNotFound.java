package com.project.Springboot_Resort_Management.exception;

public class AddressIdNotFound extends RuntimeException{

	private String message="Address Id not Found in the database";

	public String getMessage() {
		return message;
	}
	
}
