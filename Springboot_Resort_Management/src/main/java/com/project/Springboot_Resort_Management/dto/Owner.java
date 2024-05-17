package com.project.Springboot_Resort_Management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	@NotBlank(message = "Owner cannot be blank")
	@NotNull(message = "Owner cannot be null")
	private String ownerName;
	@Pattern(regexp = "[A-Z]{1}[a-z]*\\s*[A-Z]{1}{a-z}*\\s*[A-Z]{1}{a-z}*", message = "Start with capital letter and should not give in beging and last")
	private long ownerPhone;
	private double ownerNetWoth;
	private String ownerAge;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Resort> resorts;
	
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(long ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public double getOwnerNetWoth() {
		return ownerNetWoth;
	}
	public void setOwnerNetWoth(double ownerNetWoth) {
		this.ownerNetWoth = ownerNetWoth;
	}
	public String getOwnerAge() {
		return ownerAge;
	}
	public void setOwnerAge(String ownerAge) {
		this.ownerAge = ownerAge;
	}
	public List<Resort> getResorts() {
		return resorts;
	}
	public void setResorts(List<Resort> resorts) {
		this.resorts = resorts;
	}
	
}
