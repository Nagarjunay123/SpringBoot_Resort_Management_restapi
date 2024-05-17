package com.project.Springboot_Resort_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Springboot_Resort_Management.dto.Employee;
import com.project.Springboot_Resort_Management.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo employeeRepo;

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee fetchEmployeeById(int id) {
		Optional<Employee> dbEmployee = employeeRepo.findById(id);
		if (dbEmployee.isPresent()) {
			return dbEmployee.get();
		} else {
			return null;
		}
	}

	public Employee updateEmployee(int oldId, Employee employee) {
		Optional<Employee> dbEmployee = employeeRepo.findById(oldId);
		if (dbEmployee.isPresent()) {
			employee.setEmployeeId(oldId);
			return employeeRepo.save(employee);
		} else {
			return null;
		}
	}

	public Employee deleteEmployeeById(int id) {
		Optional<Employee> dbEmployee = employeeRepo.findById(id);
		if (dbEmployee.isPresent()) {
			Employee employee = employeeRepo.findById(id).get();
			employeeRepo.delete(employee);
			return employee;
		} else {
			return null;
		}
	}
}
