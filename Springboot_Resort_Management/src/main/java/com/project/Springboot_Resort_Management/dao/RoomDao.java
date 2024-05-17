package com.project.Springboot_Resort_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Springboot_Resort_Management.dto.Customer;
import com.project.Springboot_Resort_Management.dto.Room;

import com.project.Springboot_Resort_Management.repo.RoomRepo;

@Repository
public class RoomDao {
	@Autowired
	RoomRepo roomRepo;

	@Autowired
	CustomerDao customerDao;

	public Room saveRoom(Room room) {
		return roomRepo.save(room);
	}

	public Room fetchRoomById(int id) {
		Optional<Room> dbRoom = roomRepo.findById(id);
		if (dbRoom.isPresent()) {
			return dbRoom.get();
		} else {
			return null;
		}
	}

	public Room updateRoom(int oldId, Room room) {
		Optional<Room> dbRoom = roomRepo.findById(oldId);
		if (dbRoom.isPresent()) {
			room.setRoomId(oldId);
			return roomRepo.save(room);
		} else {
			return null;
		}
	}

	public Room deleteRoomById(int id) {
		Optional<Room> dbRoom = roomRepo.findById(id);
		if (dbRoom.isPresent()) {
			Room room = roomRepo.findById(id).get();
			roomRepo.delete(room);
			return room;
		} else {
			return null;
		}
	}

	public Room addExistingCustomerToExistingRoom(int oldRoomId, int oldCustomerId) {
		Optional<Room> dbRoom = roomRepo.findById(oldRoomId);
		if (dbRoom.isPresent()) {
			Room room = dbRoom.get();
			Customer customer = customerDao.fetchCustomerById(oldCustomerId);
			room.setCustomer(customer);
			return roomRepo.save(room);
		} else {
			return null;
		}
	}

	public Room addNewCustomerToExistingRoom(int oldRoomId, Customer customer) {
		Optional<Room> dbRoom = roomRepo.findById(oldRoomId);
		if (dbRoom.isPresent()) {
			Room room = fetchRoomById(oldRoomId);
			room.setCustomer(customer);
			customerDao.saveCustomer(customer);
			return roomRepo.save(room);
		} else {
			return null;
		}
	}
}
