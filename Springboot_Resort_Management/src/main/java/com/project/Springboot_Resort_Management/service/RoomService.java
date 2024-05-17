package com.project.Springboot_Resort_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Springboot_Resort_Management.dao.CustomerDao;
import com.project.Springboot_Resort_Management.dao.RoomDao;
import com.project.Springboot_Resort_Management.dto.Customer;
import com.project.Springboot_Resort_Management.dto.Room;
import com.project.Springboot_Resort_Management.exception.CustomerIdNotFound;
import com.project.Springboot_Resort_Management.exception.RoomIdNotFound;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@Service
public class RoomService {
	@Autowired
	RoomDao roomDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ResponceStructure<Room> responceStructure;

	public ResponseEntity<ResponceStructure<Room>> saveRoom(Room room) {
		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("successfully inserted into database");
		responceStructure.setData(roomDao.saveRoom(room));
		return new ResponseEntity<ResponceStructure<Room>>(responceStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructure<Room>> fetchRoomById(int id) {
		Room dbRoom = roomDao.fetchRoomById(id);
		if (dbRoom != null) {
			responceStructure.setStatusId(HttpStatus.FOUND.value());
			responceStructure.setMessage("successfully fetched into database");
			responceStructure.setData(roomDao.fetchRoomById(id));
			return new ResponseEntity<ResponceStructure<Room>>(responceStructure, HttpStatus.FOUND);
		} else {
			throw new RoomIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Room>> updateRoom(int oldId, Room room) {
		Room dbRoom = roomDao.fetchRoomById(oldId);
		if (dbRoom != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully updated into database");
			responceStructure.setData(roomDao.updateRoom(oldId, room));
			return new ResponseEntity<ResponceStructure<Room>>(responceStructure, HttpStatus.OK);
		} else {
			throw new RoomIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Room>> deleteRoomById(int id) {
		Room dbRoom = roomDao.fetchRoomById(id);
		if (dbRoom != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully deleted into database");
			responceStructure.setData(roomDao.deleteRoomById(id));
			return new ResponseEntity<ResponceStructure<Room>>(responceStructure, HttpStatus.OK);
		} else {
			throw new RoomIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Room>> addExistingCustomerToExistingRoom(int oldRoomId, int oldCustomerId) {
		Room dbRoom = roomDao.fetchRoomById(oldRoomId);
		Customer dbCustomer = customerDao.fetchCustomerById(oldCustomerId);
		if (dbRoom != null && dbCustomer != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully add Existing Customer To Existing Room into database");
			responceStructure.setData(roomDao.addExistingCustomerToExistingRoom(oldRoomId, oldCustomerId));
			return new ResponseEntity<ResponceStructure<Room>>(responceStructure, HttpStatus.OK);
		} else if (dbRoom == null) {
			throw new RoomIdNotFound();
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Room>> addNewCustomerToExistingRoom(int oldRoomId, Customer customer) {
		Room dbRoom = roomDao.fetchRoomById(oldRoomId);
		if (dbRoom != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully add New Customer To Existing Room into database");
			responceStructure.setData(roomDao.addNewCustomerToExistingRoom(oldRoomId, customer));
			return new ResponseEntity<ResponceStructure<Room>>(responceStructure, HttpStatus.OK);
		} else {
			throw new RoomIdNotFound();
		}
	}
}
