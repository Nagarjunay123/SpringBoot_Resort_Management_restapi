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

import com.project.Springboot_Resort_Management.dto.Branch;
import com.project.Springboot_Resort_Management.dto.Resort;
import com.project.Springboot_Resort_Management.service.ResortService;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@RestController
public class ResortController {

	@Autowired
	ResortService resortService;
	
	@PostMapping("/saveResort")
	public ResponseEntity<ResponceStructure<Resort>> saveResort(@RequestBody Resort resort) {
		return resortService.saveResort(resort);
	}
	
	@GetMapping("/fetchResortById")
	public ResponseEntity<ResponceStructure<Resort>> fetchResortById(@RequestParam int id) {
		return resortService.fetchResortById(id);
	}
	
	@PutMapping("/updateResort")
	public ResponseEntity<ResponceStructure<Resort>> updateResort(@RequestParam int oldId,@RequestBody Resort resort) {
		return resortService.updateResort(oldId, resort);
	}
	
	@DeleteMapping("/deleteResortById")
	public ResponseEntity<ResponceStructure<Resort>> deleteResortById(@RequestParam int id) {
		return resortService.deleteResortById(id);
	}
	
	@PutMapping("/addExistingBrachToExistingResort")
	public ResponseEntity<ResponceStructure<Resort>> addExistingBrachToExistingResort(@RequestParam int oldResort,@RequestParam int oldBranch) {
		return resortService.addExistingBrachToExistingResort(oldResort, oldBranch);
	}
	
	@PutMapping("/addNewBrachToExistingResort")
	public ResponseEntity<ResponceStructure<Resort>> addNewBrachToExistingResort(@RequestParam int oldResort,@RequestBody Branch branch) {
		return resortService.addNewBrachToExistingResort(oldResort, branch);
	}
}
