package com.project.Springboot_Resort_Management.exception;

public class EmployeeIdNotFound extends RuntimeException{

	private String message="Employee Id Not found in the Database";

	public String getMessage() {
		return message;
	}
	
}
