package com.project.Springboot_Resort_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Springboot_Resort_Management.dao.FoodDao;
import com.project.Springboot_Resort_Management.dao.OrdersDao;
import com.project.Springboot_Resort_Management.dto.Food;
import com.project.Springboot_Resort_Management.dto.Orders;
import com.project.Springboot_Resort_Management.exception.FoodIdNotFound;
import com.project.Springboot_Resort_Management.exception.OrdersIdNotFound;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@Service
public class OrdersService {
	@Autowired
	OrdersDao ordersDao;
	@Autowired
	FoodDao foodDao;
	@Autowired
	ResponceStructure<Orders> responceStructure;
	
	public ResponseEntity<ResponceStructure<Orders>> saveOrders(Orders orders) {
		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("successfully inserted into database");
		responceStructure.setData(ordersDao.saveOrders(orders));
		return new ResponseEntity<ResponceStructure<Orders>>(responceStructure, HttpStatus.CREATED) ;
		}
	
	public ResponseEntity<ResponceStructure<Orders>> fetchOrdersById(int id) {
		Orders dbOrders=ordersDao.fetchOrdersById(id);
		if(dbOrders!=null) {
		responceStructure.setStatusId(HttpStatus.FOUND.value());
		responceStructure.setMessage("successfully fetched into database");
		responceStructure.setData(ordersDao.fetchOrdersById(id));
		return new ResponseEntity<ResponceStructure<Orders>>(responceStructure, HttpStatus.FOUND) ;
		}
		else {
			throw new OrdersIdNotFound();
		}
	}
	
	public ResponseEntity<ResponceStructure<Orders>> updateOrders(int oldId,Orders orders) {
		Orders dbOrders=ordersDao.fetchOrdersById(oldId);
		if(dbOrders!=null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully updated into database");
		responceStructure.setData(ordersDao.updateOrders(oldId, orders));
		return new ResponseEntity<ResponceStructure<Orders>>(responceStructure, HttpStatus.OK) ;
		}
		else {
			throw new OrdersIdNotFound();
		}
	}
	public ResponseEntity<ResponceStructure<Orders>> deleteOrdersById(int id) {
		Orders dbOrders=ordersDao.fetchOrdersById(id);
		if(dbOrders!=null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully deleted into database");
		responceStructure.setData(ordersDao.deleteOrdersById(id));
		return new ResponseEntity<ResponceStructure<Orders>>(responceStructure, HttpStatus.OK) ;
		}
		else {
			throw new OrdersIdNotFound();
		}
	}
	public ResponseEntity<ResponceStructure<Orders>> addExistingFoodToExistingOrders(int oldOrdersId,int oldFoodId) {
		Orders dbOrders=ordersDao.fetchOrdersById(oldOrdersId);
		Food dbFood=foodDao.fetchFoodById(oldFoodId);
		if(dbOrders!=null && dbFood!=null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully add Existing Food To Existing Orders into database");
		responceStructure.setData(ordersDao.addExistingFoodToExistingOrders(oldOrdersId, oldFoodId));
		return new ResponseEntity<ResponceStructure<Orders>>(responceStructure, HttpStatus.OK) ;
		}
		else if(dbOrders==null){
			throw new OrdersIdNotFound();
		}
		else {
			throw new FoodIdNotFound();
		}
	}
	public ResponseEntity<ResponceStructure<Orders>> addNewFoodToExistingOrders(int oldOrdersId,Food food) {
		Orders dbOrders=ordersDao.fetchOrdersById(oldOrdersId);
		if(dbOrders!=null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully add New Food To Existing Orders into database");
		responceStructure.setData(ordersDao.addNewFoodToExistingOrders(oldOrdersId, food));
		return new ResponseEntity<ResponceStructure<Orders>>(responceStructure, HttpStatus.OK) ;
		}else {
			throw new OrdersIdNotFound();
		}
	}
}
