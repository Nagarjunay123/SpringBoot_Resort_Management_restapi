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
import com.project.Springboot_Resort_Management.service.AddressService;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponceStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponceStructure<Address>> fetchAddressById(@RequestParam int id) {
		return addressService.fetchAddressById(id);
	}
	
	@PutMapping("/updateAddress")
	public ResponseEntity<ResponceStructure<Address>> updateAddress(@RequestParam int oldId,@RequestBody Address address) {
		return addressService.updateAddress(oldId, address);
	}
	
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponceStructure<Address>> deleteAddressById(@RequestParam int id) {
		return addressService.deleteAddressById(id);
	}
}
