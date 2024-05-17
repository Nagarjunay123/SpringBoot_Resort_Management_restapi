package com.project.Springboot_Resort_Management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodId;
	private String foodName;
	private String foodType;
	private double foodPrice;
	private String foodQuantity;
	private double foodRating;

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(String foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public double getFoodRating() {
		return foodRating;
	}

	public void setFoodRating(double foodRating) {
		this.foodRating = foodRating;
	}

}
