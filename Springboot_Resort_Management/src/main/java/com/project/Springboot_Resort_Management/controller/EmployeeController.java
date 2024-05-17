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

import com.project.Springboot_Resort_Management.dto.Employee;
import com.project.Springboot_Resort_Management.service.EmployeeService;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponceStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/fetchEmployeeById")
	public ResponseEntity<ResponceStructure<Employee>> fetchEmployeeById(@RequestParam int id) {
		return employeeService.fetchEmployeeById(id);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<ResponceStructure<Employee>> updateEmployee(@RequestParam int oldId,@RequestBody Employee employee) {
		return employeeService.updateEmployee(oldId, employee);
	}
	
	@DeleteMapping("/deleteEmployeeById")
	public ResponseEntity<ResponceStructure<Employee>> deleteEmployeeById(@RequestParam int id) {
		return employeeService.deleteEmployeeById(id);
	}
}
