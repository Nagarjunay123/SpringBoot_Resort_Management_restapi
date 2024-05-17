package com.project.Springboot_Resort_Management.util;

import org.springframework.stereotype.Component;

@Component
public class ResponceStructure<T> {

	private int statusId;
	private String message;
	private T data;
	
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
