package com.project.Springboot_Resort_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Springboot_Resort_Management.dao.OwnerDao;
import com.project.Springboot_Resort_Management.dao.ResortDao;
import com.project.Springboot_Resort_Management.dto.Owner;
import com.project.Springboot_Resort_Management.dto.Resort;
import com.project.Springboot_Resort_Management.exception.OwnerIdNotFound;
import com.project.Springboot_Resort_Management.exception.ResortIdNotFound;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;
	@Autowired
	ResortDao resortDao;
	@Autowired
	ResponceStructure<Owner> responceStructure;

	public ResponseEntity<ResponceStructure<Owner>> saveOwner(Owner owner) {
		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("successfully inserted into database");
		responceStructure.setData(ownerDao.saveOwner(owner));
		return new ResponseEntity<ResponceStructure<Owner>>(responceStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructure<Owner>> fetchOwnerById(int id) {
		Owner owner = ownerDao.fetchOwnerById(id);
		if (owner != null) {

			responceStructure.setStatusId(HttpStatus.FOUND.value());
			responceStructure.setMessage("successfully fetched into database");
			responceStructure.setData(ownerDao.fetchOwnerById(id));
			return new ResponseEntity<ResponceStructure<Owner>>(responceStructure, HttpStatus.FOUND);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Owner>> updateOwnerById(int id, Owner owner) {
		Owner dbowner = ownerDao.fetchOwnerById(id);
		if (dbowner != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully updated into database");
			responceStructure.setData(ownerDao.updateOwner(id, owner));
			return new ResponseEntity<ResponceStructure<Owner>>(responceStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Owner>> deleteOwnerById(int id) {
		Owner dbowner = ownerDao.fetchOwnerById(id);
		if (dbowner != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully deleted into database");
			responceStructure.setData(ownerDao.deleteOwnerById(id));
			return new ResponseEntity<ResponceStructure<Owner>>(responceStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Owner>> addExistingResortToExistingOwner(int oldOwnerId, int oldResortId) {
		Owner dbowner = ownerDao.fetchOwnerById(oldOwnerId);
		Resort dbResort=resortDao.fetchResortById(oldResortId);
		if (dbowner != null && dbResort!=null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully add Existing Resort To Existing Owner into database");
			responceStructure.setData(ownerDao.addExistingResortToExistingOwner(oldOwnerId, oldResortId));
			return new ResponseEntity<ResponceStructure<Owner>>(responceStructure, HttpStatus.OK);
		} else if(dbowner==null){
			throw new OwnerIdNotFound();
		}
		else {
			throw new ResortIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Owner>> addNewResortToExistingOwner(int oldOwnerId, Resort resort) {
		Owner dbowner = ownerDao.fetchOwnerById(oldOwnerId);
		if (dbowner != null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully add New Resort To Existing Owner into database");
		responceStructure.setData(ownerDao.addNewResortToExistingOwner(oldOwnerId, resort));
		return new ResponseEntity<ResponceStructure<Owner>>(responceStructure, HttpStatus.OK);
	}
		else {
			throw new OwnerIdNotFound();
		}		
	}
}
