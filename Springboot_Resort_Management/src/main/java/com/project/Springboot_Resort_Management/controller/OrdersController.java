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
import com.project.Springboot_Resort_Management.dto.Orders;
import com.project.Springboot_Resort_Management.service.OrdersService;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@RestController
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	
	@PostMapping("/saveOrders")
	public ResponseEntity<ResponceStructure<Orders>> savOrders(@RequestBody Orders orders) {
		return ordersService.saveOrders(orders);
	}
	
	@GetMapping("/fetchOrdersById")
	public ResponseEntity<ResponceStructure<Orders>> fetchOrdersById(@RequestParam int id) {
		return ordersService.fetchOrdersById(id);
	}
	
	@PutMapping("/updateOrders")
	public ResponseEntity<ResponceStructure<Orders>> updateOrders(@RequestParam int oldId,@RequestBody Orders orders) {
		return ordersService.updateOrders(oldId, orders);
	}
	
	@DeleteMapping("/deleteOrdersById")
	public ResponseEntity<ResponceStructure<Orders>> deleteOrdersById(@RequestParam int id) {
		return ordersService.deleteOrdersById(id);
	}
	@PutMapping("/addExistingFoodToExistingOrders")
	public ResponseEntity<ResponceStructure<Orders>> addExistingFoodToExistingOrders(@RequestParam int oldOrdersId,@RequestParam int oldFoodId) {
		return ordersService.addExistingFoodToExistingOrders(oldOrdersId, oldFoodId);
	}
	
	@PutMapping("/addNewFoodToExistingOrders")
	public ResponseEntity<ResponceStructure<Orders>> addNewFoodToExistingOrders(@RequestParam int oldOrdersId,@RequestBody Food food) {
		return ordersService.addNewFoodToExistingOrders(oldOrdersId, food);
	}
}
