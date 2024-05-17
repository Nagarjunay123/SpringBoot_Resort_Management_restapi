package com.project.Springboot_Resort_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Springboot_Resort_Management.dao.FoodDao;
import com.project.Springboot_Resort_Management.dto.Food;
import com.project.Springboot_Resort_Management.exception.FoodIdNotFound;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@Service
public class FoodService {
	@Autowired
	FoodDao foodDao;
	@Autowired
	ResponceStructure<Food> responceStructure;
	
	public ResponseEntity<ResponceStructure<Food>> saveFood(Food food) {
		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("successfully inserted into database");
		responceStructure.setData(foodDao.saveFood(food));
		return new ResponseEntity<ResponceStructure<Food>>(responceStructure, HttpStatus.CREATED) ;
		}
	
	public ResponseEntity<ResponceStructure<Food>> fetchFoodById(int id) {
		Food dbFood=foodDao.fetchFoodById(id);
		if(dbFood!=null) {
		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("successfully fetched into database");
		responceStructure.setData(foodDao.fetchFoodById(id));
		return new ResponseEntity<ResponceStructure<Food>>(responceStructure, HttpStatus.FOUND) ;
		}
		else {
			throw new FoodIdNotFound();
		}
	}
	
	public ResponseEntity<ResponceStructure<Food>> updateFood(int oldId,Food food) {
		Food dbFood=foodDao.fetchFoodById(oldId);
		if(dbFood!=null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully updated in database");
		responceStructure.setData(foodDao.updateFood(oldId, food));
		return new ResponseEntity<ResponceStructure<Food>>(responceStructure, HttpStatus.OK) ;
		}else {
			throw new FoodIdNotFound();
		}
	}
	
	public ResponseEntity<ResponceStructure<Food>> deleteFoodById(int id) {
		Food dbFood=foodDao.fetchFoodById(id);
		if(dbFood!=null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully deleted into database");
		responceStructure.setData(foodDao.deleteFoodById(id));
		return new ResponseEntity<ResponceStructure<Food>>(responceStructure, HttpStatus.OK) ;
		}else {
			throw new FoodIdNotFound();
		}
	}
}
