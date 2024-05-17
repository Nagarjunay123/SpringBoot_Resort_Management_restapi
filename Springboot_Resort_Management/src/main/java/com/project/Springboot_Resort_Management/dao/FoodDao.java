package com.project.Springboot_Resort_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Springboot_Resort_Management.dto.Food;
import com.project.Springboot_Resort_Management.repo.FoodRepo;

@Repository
public class FoodDao {
	@Autowired
	FoodRepo foodRepo;

	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}

	public Food fetchFoodById(int id) {
		Optional<Food> dbFood = foodRepo.findById(id);
		if (dbFood.isPresent()) {
			return dbFood.get();
		} else {
			return null;
		}
	}

	public Food updateFood(int oldId, Food food) {
		Optional<Food> dbFood = foodRepo.findById(oldId);
		if (dbFood.isPresent()) {
		food.setFoodId(oldId);
		return foodRepo.save(food);
		}
		return null;
	}

	public Food deleteFoodById(int id) {
		Optional<Food> dbFood = foodRepo.findById(id);
		if (dbFood.isPresent()) {
		Food food = foodRepo.findById(id).get();
		foodRepo.delete(food);
		return food;
		}
		else {
			return null;
		}
	}
}
