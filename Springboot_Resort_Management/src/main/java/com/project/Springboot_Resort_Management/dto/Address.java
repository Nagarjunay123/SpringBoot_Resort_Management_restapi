package com.project.Springboot_Resort_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String addressPlotNo;
	private String addressStreet;
	private String addresslandMark;
	private String addressCity;
	private String addressState;
	private int addressPincode;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressPlotNo() {
		return addressPlotNo;
	}
	public void setAddressPlotNo(String addressPlotNo) {
		this.addressPlotNo = addressPlotNo;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddresslandMark() {
		return addresslandMark;
	}
	public void setAddresslandMark(String addresslandMark) {
		this.addresslandMark = addresslandMark;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public int getAddressPincode() {
		return addressPincode;
	}
	public void setAddressPincode(int addressPincode) {
		this.addressPincode = addressPincode;
	}
	
}
