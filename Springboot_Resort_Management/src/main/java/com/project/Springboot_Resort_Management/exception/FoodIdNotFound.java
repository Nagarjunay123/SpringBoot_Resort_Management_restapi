package com.project.Springboot_Resort_Management.exception;

public class FoodIdNotFound extends RuntimeException{

	private String message="Food Id Not found in the Database";

	public String getMessage() {
		return message;
	}
	
}
