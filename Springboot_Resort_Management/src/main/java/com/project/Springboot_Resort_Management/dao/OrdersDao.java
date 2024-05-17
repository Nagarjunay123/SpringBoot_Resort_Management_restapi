package com.project.Springboot_Resort_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Springboot_Resort_Management.dto.Food;
import com.project.Springboot_Resort_Management.dto.Orders;

import com.project.Springboot_Resort_Management.repo.OrdersRepo;

@Repository
public class OrdersDao {
	@Autowired
	OrdersRepo ordersRepo;

	@Autowired
	FoodDao foodDao;

	public Orders saveOrders(Orders orders) {
		return ordersRepo.save(orders);
	}

	public Orders fetchOrdersById(int id) {
		Optional<Orders> dbOrders = ordersRepo.findById(id);
		if (dbOrders.isPresent()) {
			return dbOrders.get();
		} else {
			return null;
		}
	}

	public Orders updateOrders(int oldId, Orders orders) {
		Optional<Orders> dbOrders = ordersRepo.findById(oldId);
		if (dbOrders.isPresent()) {
			orders.setOrderId(oldId);
			return ordersRepo.save(orders);
		} else {
			return null;
		}
	}

	public Orders deleteOrdersById(int id) {
		Optional<Orders> dbOrders = ordersRepo.findById(id);
		if (dbOrders.isPresent()) {
			Orders orders = dbOrders.get();
			ordersRepo.delete(orders);
			return orders;
		} else {
			return null;
		}
	}

	public Orders addExistingFoodToExistingOrders(int oldOrdersId, int oldFoodId) {
		Optional<Orders> dbOrders = ordersRepo.findById(oldOrdersId);
		if (dbOrders.isPresent()) {
			Orders orders = dbOrders.get();
			Food food = foodDao.fetchFoodById(oldFoodId);
			List<Food> list = orders.getFood();
			list.add(food);
			return ordersRepo.save(orders);
		} else {
			return null;
		}
	}

	public Orders addNewFoodToExistingOrders(int oldOrdersId, Food food) {
		Optional<Orders> dbOrders = ordersRepo.findById(oldOrdersId);
		if (dbOrders.isPresent()) {
			Orders orders = dbOrders.get();
			List<Food> list = orders.getFood();
			list.add(food);
			return ordersRepo.save(orders);
		} else {
			return null;
		}
	}

}
