package com.project.Springboot_Resort_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Springboot_Resort_Management.dto.Food;
import com.project.Springboot_Resort_Management.service.FoodService;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@RestController
public class FoodController {
	@Autowired
	FoodService foodService;
	
	@Autowired
	ResponceStructure<Food> responceStructure;
	
	@PostMapping("/saveFood")
	public ResponseEntity<ResponceStructure<Food>> saveFood(@RequestBody Food food) {
		return foodService.saveFood(food);
	}
	
	@GetMapping("/fetchFoodById")
	public ResponseEntity<ResponceStructure<Food>> fetchFoodById(@RequestParam int id) {
		return foodService.fetchFoodById(id);
	}
	
	@PutMapping("/updateFood")
	public ResponseEntity<ResponceStructure<Food>> updateFood(@RequestParam int oldId,@RequestBody Food food) {
		return foodService.updateFood(oldId, food);
	}
	
	@DeleteMapping("/deleteFoodById")
	public ResponseEntity<ResponceStructure<Food>> deleteFoodById(@RequestParam int id) {
		return foodService.deleteFoodById(id);
	}
}
