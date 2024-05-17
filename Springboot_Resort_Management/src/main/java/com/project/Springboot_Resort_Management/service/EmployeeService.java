package com.project.Springboot_Resort_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Springboot_Resort_Management.dao.EmployeeDao;
import com.project.Springboot_Resort_Management.dto.Employee;
import com.project.Springboot_Resort_Management.exception.EmployeeIdNotFound;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	ResponceStructure<Employee> responceStructure;

	public ResponseEntity<ResponceStructure<Employee>> saveEmployee(Employee employee) {
		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("successfully inserted into database");
		responceStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponceStructure<Employee>>(responceStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructure<Employee>> fetchEmployeeById(int id) {
		Employee dbEmployee = employeeDao.fetchEmployeeById(id);
		if (dbEmployee != null) {
			responceStructure.setStatusId(HttpStatus.FOUND.value());
			responceStructure.setMessage("successfully fetched into database");
			responceStructure.setData(employeeDao.fetchEmployeeById(id));
			return new ResponseEntity<ResponceStructure<Employee>>(responceStructure, HttpStatus.FOUND);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Employee>> updateEmployee(int oldId, Employee employee) {
		Employee dbEmployee = employeeDao.fetchEmployeeById(oldId);
		if (dbEmployee != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully updated in database");
			responceStructure.setData(employeeDao.updateEmployee(oldId, employee));
			return new ResponseEntity<ResponceStructure<Employee>>(responceStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Employee>> deleteEmployeeById(int id) {
		Employee dbEmployee = employeeDao.fetchEmployeeById(id);
		if (dbEmployee != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully updated in database");
			responceStructure.setData(employeeDao.deleteEmployeeById(id));
			return new ResponseEntity<ResponceStructure<Employee>>(responceStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();

		}
	}
}
