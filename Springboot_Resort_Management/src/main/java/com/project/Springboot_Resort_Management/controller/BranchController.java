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

import com.project.Springboot_Resort_Management.dto.Address;
import com.project.Springboot_Resort_Management.dto.Branch;
import com.project.Springboot_Resort_Management.dto.Employee;
import com.project.Springboot_Resort_Management.dto.Manager;
import com.project.Springboot_Resort_Management.dto.Room;
import com.project.Springboot_Resort_Management.service.BranchService;
import com.project.Springboot_Resort_Management.util.ResponceStructure;
@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponceStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	
	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponceStructure<Branch>> fetchBranchById(@RequestParam int id) {
		return branchService.fetchBranchById(id);
	}
	
	@PutMapping("/updateBranch")
	public ResponseEntity<ResponceStructure<Branch>> updateBranch(@RequestParam int oldId,@RequestBody Branch branch) {
		return branchService.updateBranch(oldId, branch);
	}
	
	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponceStructure<Branch>> deleteBranchById(@RequestParam int id) {
		return branchService.deleteBranchById(id);
	}
	
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseEntity<ResponceStructure<Branch>> addExistingAddressToExistingBranch(@RequestParam int oldBranchId,@RequestParam int oldAddressId) {
		return branchService.addExistingAddressToExistingBranch(oldBranchId, oldAddressId);
	}
	
	@PutMapping("/addNewAddressToExistingBranch")
	public ResponseEntity<ResponceStructure<Branch>> addNewAddressToExistingBranch(@RequestParam int oldBranchId,@RequestBody Address address) {
		return branchService.addNewAddressToExistingBranch(oldBranchId, address);
	}
	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseEntity<ResponceStructure<Branch>> addExistingManagerToExistingBranch(@RequestParam int oldBranchId,@RequestParam int oldManagerId) {
		return branchService.addExistingManagerToExistingBranch(oldBranchId, oldManagerId);
	}
	
	@PutMapping("/addNewManagerToExistingBranch")
	public ResponseEntity<ResponceStructure<Branch>> addNewManagerToExistingBranch(@RequestParam int oldBranchId,@RequestBody Manager manager) {
		return branchService.addNewManagerToExistingBranch(oldBranchId, manager);
	}
	
	@PutMapping("/addExistingEmployeeToExistingBranch")
	public ResponseEntity<ResponceStructure<Branch>> addExistingEmployeeToExistingBranch(@RequestParam int oldBranchId,@RequestParam int oldEmployeeId) {
		return branchService.addExistingEmployeeToExistingBranch(oldBranchId, oldEmployeeId);
	}
	
	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseEntity<ResponceStructure<Branch>> addNewEmployeeToExistingBranch(@RequestParam int oldBranchId,@RequestBody Employee employee) {
		return branchService.addNewEmployeeToExistingBranch(oldBranchId, employee);
	}
	@PutMapping("/addExistingRoomToExistingBranch")
	public ResponseEntity<ResponceStructure<Branch>> addExistingRoomToExistingBranch(@RequestParam int oldBranchId,@RequestParam int oldRoomId) {
		return branchService.addExistingRoomToExistingBranch(oldBranchId, oldRoomId);
	}
	
	@PutMapping("/addNewRoomToExistingBranch")
	public ResponseEntity<ResponceStructure<Branch>> addNewRoomToExistingBranch(@RequestParam int oldBranchId,@RequestBody Room room) {
		return branchService.addNewRoomToExistingBranch(oldBranchId, room);
	}
}
