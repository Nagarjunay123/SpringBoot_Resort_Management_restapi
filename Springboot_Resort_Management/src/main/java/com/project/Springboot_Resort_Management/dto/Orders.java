package com.project.Springboot_Resort_Management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private int orderNumber;
	private int orderQuantity;
	private double orderGST;
	private double orderDiscount;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Food> food;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public double getOrderGST() {
		return orderGST;
	}
	public void setOrderGST(double orderGST) {
		this.orderGST = orderGST;
	}
	public double getOrderDiscount() {
		return orderDiscount;
	}
	public void setOrderDiscount(double orderDiscount) {
		this.orderDiscount = orderDiscount;
	}
	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	
}
