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

import com.project.Springboot_Resort_Management.dto.Manager;
import com.project.Springboot_Resort_Management.service.ManagerService;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@RestController
public class ManagerController {

	@Autowired
	ManagerService managerService;
	
	@PostMapping("/saveManager")
	public ResponseEntity<ResponceStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}
	
	@GetMapping("/fetchManagerById")
	public ResponseEntity<ResponceStructure<Manager>> fetchManagerById(@RequestParam int id) {
		return managerService.fetchManagerById(id);
	}
	
	@PutMapping("/updateManager")
	public ResponseEntity<ResponceStructure<Manager>> updateManager(@RequestParam int oldId,@RequestBody Manager manager) {
		return managerService.updateManager(oldId, manager);
	}
	
	@DeleteMapping("/deleteManagerById")
	public ResponseEntity<ResponceStructure<Manager>> deleteManagerById(@RequestParam int id) {
		return managerService.deleteManagerById(id);
	}
}
