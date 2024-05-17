package com.project.Springboot_Resort_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Springboot_Resort_Management.dto.Address;
import com.project.Springboot_Resort_Management.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}

	public Address fetchAddressById(int id) {
		Optional<Address> address = addressRepo.findById(id);
		if (address.isPresent()) {
			return address.get();
		} else {
			return null;
		}
	}

	public Address updateAddress(int oldId, Address address) {
		Optional<Address> dbaddress = addressRepo.findById(oldId);
		if (dbaddress.isPresent()) {
			address.setAddressId(oldId);
			return addressRepo.save(address);
		} else {
			return null;
		}
	}

	public Address deleteAddressById(int id) {
		Optional<Address> dbaddress = addressRepo.findById(id);
		if (dbaddress.isPresent()) {
		Address address = dbaddress.get();
		addressRepo.delete(address);
		return address;
	}
		else{
			return null;
			}
		}
}
