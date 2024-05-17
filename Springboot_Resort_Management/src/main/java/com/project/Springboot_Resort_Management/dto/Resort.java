package com.project.Springboot_Resort_Management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Resort {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resortId;
	private String resortName;
	private String resortEmail;
	private long resortPhone;
	private double resortRating;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Branch> branch;
	
	public int getResortId() {
		return resortId;
	}
	public void setResortId(int resortId) {
		this.resortId = resortId;
	}
	public String getResortName() {
		return resortName;
	}
	public void setResortName(String resortName) {
		this.resortName = resortName;
	}
	public String getResortEmail() {
		return resortEmail;
	}
	public void setResortEmail(String resortEmail) {
		this.resortEmail = resortEmail;
	}
	public long getResortPhone() {
		return resortPhone;
	}
	public void setResortPhone(long resortPhone) {
		this.resortPhone = resortPhone;
	}
	public double getResortRating() {
		return resortRating;
	}
	public void setResortRating(double resortRating) {
		this.resortRating = resortRating;
	}
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}
	
}
