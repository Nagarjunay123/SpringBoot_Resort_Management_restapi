package com.project.Springboot_Resort_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int managerId;
	private String managerName;
	private double managerSalary;
	private long managerPhone;
	private int managerAge;
	
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public double getManagerSalary() {
		return managerSalary;
	}
	public void setManagerSalary(double managerSalary) {
		this.managerSalary = managerSalary;
	}
	public long getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(long managerPhone) {
		this.managerPhone = managerPhone;
	}
	public int getManagerAge() {
		return managerAge;
	}
	public void setManagerAge(int managerAge) {
		this.managerAge = managerAge;
	}
	
}
