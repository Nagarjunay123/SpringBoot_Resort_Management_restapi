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

import com.project.Springboot_Resort_Management.dto.Customer;
import com.project.Springboot_Resort_Management.dto.Orders;
import com.project.Springboot_Resort_Management.service.CustomerService;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponceStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/fetchCustomerById")
	public ResponseEntity<ResponceStructure<Customer>> fetchCustomerById(@RequestParam int id) {
		return customerService.fetchCustomerById(id);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<ResponceStructure<Customer>> updateCustomer(@RequestParam int oldId,@RequestBody Customer customer) {
		return customerService.updateCustomer(oldId, customer);
	}
	
	@DeleteMapping("/deleteCustomerById")
	public ResponseEntity<ResponceStructure<Customer>> deleteCustomerById(@RequestParam int id) {
		return customerService.deleteCustomerById(id);
	}
	
	@PutMapping("/addExistingOrdersToExistingCustomer")
	public ResponseEntity<ResponceStructure<Customer>> addExistingOrdersToExistingCustomer(@RequestParam int oldCustomerId,@RequestParam int oldOrdersId) {
		return customerService.addExistingOrdersToExistingCustomer(oldCustomerId, oldOrdersId);
	}
	
	@PutMapping("/addNewOrdersToExistingCustomer")
	public ResponseEntity<ResponceStructure<Customer>> addNewOrdersToExistingCustomer(@RequestParam int oldCustomerId,@RequestBody Orders orders) {
		return customerService.addNewOrdersToExistingCustomer(oldCustomerId, orders);
	}
}
