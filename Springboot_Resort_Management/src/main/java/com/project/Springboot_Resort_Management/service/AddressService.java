package com.project.Springboot_Resort_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Springboot_Resort_Management.dao.AddressDao;
import com.project.Springboot_Resort_Management.dto.Address;
import com.project.Springboot_Resort_Management.exception.AddressIdNotFound;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;

	@Autowired
	ResponceStructure<Address> responceStructure;

	public ResponseEntity<ResponceStructure<Address>> saveAddress(Address address) {
		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("Successfully inserted into DataBase");
		responceStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponceStructure<Address>>(responceStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructure<Address>> fetchAddressById(int id) {
		Address dbaddress = addressDao.fetchAddressById(id);
		if (dbaddress != null) {
			responceStructure.setStatusId(HttpStatus.FOUND.value());
			responceStructure.setMessage("Successfully fetched into DataBase");
			responceStructure.setData(addressDao.fetchAddressById(id));
			return new ResponseEntity<ResponceStructure<Address>>(responceStructure, HttpStatus.FOUND);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Address>> updateAddress(int oldId, Address address) {
		Address dbaddress = addressDao.fetchAddressById(oldId);
		if (dbaddress != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully updated in DataBase");
			responceStructure.setData(addressDao.updateAddress(oldId, address));
			return new ResponseEntity<ResponceStructure<Address>>(responceStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Address>> deleteAddressById(int id) {
		Address dbaddress = addressDao.fetchAddressById(id);
		if (dbaddress != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			;
			responceStructure.setMessage("Successfully deleted into DataBase");
			responceStructure.setData(addressDao.deleteAddressById(id));
			return new ResponseEntity<ResponceStructure<Address>>(responceStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}
}