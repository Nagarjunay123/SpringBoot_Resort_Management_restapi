package com.project.Springboot_Resort_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Springboot_Resort_Management.dto.Customer;
import com.project.Springboot_Resort_Management.dto.Orders;
import com.project.Springboot_Resort_Management.repo.CustomerRepo;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	OrdersDao ordersDao;

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer fetchCustomerById(int id) {
		Optional<Customer> dbCustomer = customerRepo.findById(id);
		if (dbCustomer.isPresent()) {
			return customerRepo.findById(id).get();
		} else {
			return null;
		}
	}

	public Customer updateCustomer(int oldId, Customer customer) {
		Optional<Customer> dbCustomer = customerRepo.findById(oldId);
		if (dbCustomer.isPresent()) {
			customer.setCustomerId(oldId);
			return customerRepo.save(customer);
		} else {
			return null;
		}
	}

	public Customer deleteCustomerById(int id) {
		Optional<Customer> dbCustomer = customerRepo.findById(id);
		if (dbCustomer.isPresent()) {
			Customer customer = customerRepo.findById(id).get();
			customerRepo.delete(customer);
			return customer;
		} else {
			return null;
		}
	}

	public Customer addExistingOrdersToExistingCustomer(int oldCustomerId, int oldOrdersId) {
		Optional<Customer> dbCustomer = customerRepo.findById(oldCustomerId);
		if (dbCustomer.isPresent()) {
			Customer customer = fetchCustomerById(oldCustomerId);
			Orders orders = ordersDao.fetchOrdersById(oldOrdersId);
			List<Orders> list = customer.getOrders();
			list.add(orders);
			return customerRepo.save(customer);
		} else {
			return null;
		}
	}

	public Customer addNewOrdersToExistingCustomer(int oldCustomerId, Orders orders) {
		Optional<Customer> dbCustomer = customerRepo.findById(oldCustomerId);
		if (dbCustomer.isPresent()) {
			Customer customer = fetchCustomerById(oldCustomerId);
			List<Orders> list = customer.getOrders();
			list.add(orders);
			return customerRepo.save(customer);
		} else {
			return null;
		}
	}
}
