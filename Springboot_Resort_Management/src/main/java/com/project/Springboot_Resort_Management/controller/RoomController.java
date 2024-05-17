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

import com.project.Springboot_Resort_Management.dto.Customer;
import com.project.Springboot_Resort_Management.dto.Room;
import com.project.Springboot_Resort_Management.service.RoomService;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@RestController
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@PostMapping("/saveRoom")
	public ResponseEntity<ResponceStructure<Room>> saveRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}
	
	@GetMapping("/fetchRoomById")
	public ResponseEntity<ResponceStructure<Room>> fetchRoomById(@RequestParam int id) {
		return roomService.fetchRoomById(id);
	}
	
	@PutMapping("/updateRoom")
	public ResponseEntity<ResponceStructure<Room>> updateRoom(@RequestParam int oldId,@RequestBody Room room) {
		return roomService.updateRoom(oldId, room);
	}
	
	@DeleteMapping("/deleteRoomById")
	public ResponseEntity<ResponceStructure<Room>> deleteRoomById(@RequestParam int id) {
		return roomService.deleteRoomById(id);
	}
	
	@PutMapping("/addExistingCustomerToExistingRoom")
	public ResponseEntity<ResponceStructure<Room>> addExistingCustomerToExistingRoom(@RequestParam int oldRoomId,@RequestParam int oldCustomerId) {
		return roomService.addExistingCustomerToExistingRoom(oldRoomId, oldCustomerId);
	}
	
	@PutMapping("/addNewCustomerToExistingRoom")
	public ResponseEntity<ResponceStructure<Room>> addNewCustomerToExistingRoom(@RequestParam int oldRoomId,@RequestBody Customer customer) {
		return roomService.addNewCustomerToExistingRoom(oldRoomId, customer);
	}
}
