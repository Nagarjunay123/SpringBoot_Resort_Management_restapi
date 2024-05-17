package com.project.Springboot_Resort_Management.exception;

public class RoomIdNotFound extends RuntimeException{

	private String message="Room id not found in the database";

	public String getMessage() {
		return message;
	}
	
}
