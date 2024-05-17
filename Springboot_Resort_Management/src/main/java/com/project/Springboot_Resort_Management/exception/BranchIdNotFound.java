package com.project.Springboot_Resort_Management.exception;

public class BranchIdNotFound extends RuntimeException{

	private String message="Branch Id not Found in the databaase";

	public String getMessage() {
		return message;
	}
	
}
