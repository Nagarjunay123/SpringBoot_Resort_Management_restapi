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

import com.project.Springboot_Resort_Management.dto.Owner;
import com.project.Springboot_Resort_Management.dto.Resort;
import com.project.Springboot_Resort_Management.service.OwnerService;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@RestController
public class OwnerController {

	@Autowired
	OwnerService ownerService;
	
	@PostMapping("/saveOwner")
	public ResponseEntity<ResponceStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	
	@GetMapping("/fetchById")
	public ResponseEntity<ResponceStructure<Owner>> fetchById(@RequestParam int id) {
		return ownerService.fetchOwnerById(id);
	}
	
	@PutMapping("/updateOwnerById")
	public ResponseEntity<ResponceStructure<Owner>> updateOwnerById(@RequestParam int id,@RequestBody Owner owner) {
		return ownerService.updateOwnerById(id, owner);
	}
	
	@DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponceStructure<Owner>> deleteOwnerById(@RequestParam int id) {
		return ownerService.fetchOwnerById(id);
	}
	
	@PutMapping("/addExistingResortToExistingOwner")
	public ResponseEntity<ResponceStructure<Owner>> addExistingResortToExistingOwner(@RequestParam int oldOwnerId,@RequestParam int oldResortId) {
		return ownerService.addExistingResortToExistingOwner(oldOwnerId, oldResortId);
	}
	
	@PutMapping("/addNewResortToExistingOwner")
	public ResponseEntity<ResponceStructure<Owner>> addNewResortToExistingOwner(@RequestParam int oldOwnerId,@RequestBody Resort resort) {
		return ownerService.addNewResortToExistingOwner(oldOwnerId, resort);
	}
	
}
