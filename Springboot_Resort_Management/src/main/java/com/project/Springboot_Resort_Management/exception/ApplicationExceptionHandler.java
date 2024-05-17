package com.project.Springboot_Resort_Management.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.Springboot_Resort_Management.dto.Address;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	ResponceStructure<String> responceStructure;

	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		responceStructure.setStatusId(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage("Id not found");
		responceStructure.setData(ownerIdNotFound.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> addressIdNotFound(AddressIdNotFound addressIdNotFound) {
		responceStructure.setStatusId(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage("Sorry Address Id Not Found in the database");
		responceStructure.setData(addressIdNotFound.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> employeeIdNotFound(EmployeeIdNotFound employeeIdNotFound) {
		responceStructure.setStatusId(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage("Sorry Employee Id Not Found in the database");
		responceStructure.setData(employeeIdNotFound.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> foodIdNotFound(FoodIdNotFound foodIdNotFound) {
		responceStructure.setStatusId(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage("Sorry food Id Not Found in the database");
		responceStructure.setData(foodIdNotFound.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> foodIdNotFound(ManagerIdNotFound managerIdNotFound) {
		responceStructure.setStatusId(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage("Sorry food Id Not Found in the database");
		responceStructure.setData(managerIdNotFound.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> branchIdNotFound(BranchIdNotFound branchIdNotFound) {
		responceStructure.setStatusId(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage("Sorry branch Id Not Found in the database");
		responceStructure.setData(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> customerIdNotFound(CustomerIdNotFound customerIdNotFound) {
		responceStructure.setStatusId(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage("Sorry customer Id Not Found in the database");
		responceStructure.setData(customerIdNotFound.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(OrdersIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> ordersIdNotFound(OrdersIdNotFound ordersIdNotFound) {
		responceStructure.setStatusId(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage("Sorry orders Id Not Found in the database");
		responceStructure.setData(ordersIdNotFound.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResortIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> resortIdNotFound(ResortIdNotFound resortIdNotFound) {
		responceStructure.setStatusId(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage("Sorry Resort Id Not Found in the database");
		responceStructure.setData(resortIdNotFound.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RoomIdNotFound.class)
	public ResponseEntity<ResponceStructure<String>> roomIdNotFound(RoomIdNotFound roomIdNotFound) {
		responceStructure.setStatusId(HttpStatus.NOT_FOUND.value());
		responceStructure.setMessage("Sorry Resort Id Not Found in the database");
		responceStructure.setData(roomIdNotFound.getMessage());
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.NOT_FOUND);
	}
}
