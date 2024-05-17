package com.project.Springboot_Resort_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Springboot_Resort_Management.dao.CustomerDao;
import com.project.Springboot_Resort_Management.dao.OrdersDao;
import com.project.Springboot_Resort_Management.dto.Customer;
import com.project.Springboot_Resort_Management.dto.Orders;
import com.project.Springboot_Resort_Management.exception.CustomerIdNotFound;
import com.project.Springboot_Resort_Management.exception.OrdersIdNotFound;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	OrdersDao ordersDao;
	@Autowired
	ResponceStructure<Customer> responceStructure;

	public ResponseEntity<ResponceStructure<Customer>> saveCustomer(Customer customer) {
		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("successfully inserted into database");
		responceStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponceStructure<Customer>>(responceStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructure<Customer>> fetchCustomerById(int id) {
		Customer dbCustomer = customerDao.fetchCustomerById(id);
		if (dbCustomer != null) {
			responceStructure.setStatusId(HttpStatus.FOUND.value());
			responceStructure.setMessage("successfully fetched into database");
			responceStructure.setData(customerDao.fetchCustomerById(id));
			return new ResponseEntity<ResponceStructure<Customer>>(responceStructure, HttpStatus.FOUND);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Customer>> updateCustomer(int oldId, Customer customer) {
		Customer dbCustomer = customerDao.fetchCustomerById(oldId);
		if (dbCustomer != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully inserted into database");
			responceStructure.setData(customerDao.updateCustomer(oldId, customer));
			return new ResponseEntity<ResponceStructure<Customer>>(responceStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Customer>> deleteCustomerById(int id) {
		Customer dbCustomer = customerDao.fetchCustomerById(id);
		if (dbCustomer != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully deleted into database");
			responceStructure.setData(customerDao.deleteCustomerById(id));
			return new ResponseEntity<ResponceStructure<Customer>>(responceStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Customer>> addExistingOrdersToExistingCustomer(int oldCustomerId,
			int oldOrdersId) {
		Customer dbCustomer = customerDao.fetchCustomerById(oldCustomerId);
		Orders dbOrders=ordersDao.fetchOrdersById(oldOrdersId);
		if (dbCustomer != null && dbOrders!=null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully add Existing Orders To Existing Customer into database");
			responceStructure.setData(customerDao.addExistingOrdersToExistingCustomer(oldCustomerId, oldOrdersId));
			return new ResponseEntity<ResponceStructure<Customer>>(responceStructure, HttpStatus.OK);
		} else if(dbCustomer == null){
			throw new CustomerIdNotFound();
		}
		else {
			throw new OrdersIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Customer>> addNewOrdersToExistingCustomer(int oldCustomerId,
			Orders orders) {
		Customer dbCustomer = customerDao.fetchCustomerById(oldCustomerId);
		if (dbCustomer != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully add New Orders To Existing Customer into database");
			responceStructure.setData(customerDao.addNewOrdersToExistingCustomer(oldCustomerId, orders));
			return new ResponseEntity<ResponceStructure<Customer>>(responceStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}
}
