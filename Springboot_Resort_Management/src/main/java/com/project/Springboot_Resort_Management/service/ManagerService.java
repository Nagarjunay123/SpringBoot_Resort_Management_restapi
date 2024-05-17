package com.project.Springboot_Resort_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Springboot_Resort_Management.dao.ManagerDao;
import com.project.Springboot_Resort_Management.dto.Manager;
import com.project.Springboot_Resort_Management.exception.ManagerIdNotFound;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;
	@Autowired
	ResponceStructure<Manager> responceStructure;

	public ResponseEntity<ResponceStructure<Manager>> saveManager(Manager manager) {
		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("successfully inserted into database");
		responceStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<ResponceStructure<Manager>>(responceStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructure<Manager>> fetchManagerById(int id) {
		Manager dbManager = managerDao.fetchManagerById(id);
		if (dbManager != null) {
			responceStructure.setStatusId(HttpStatus.FOUND.value());
			responceStructure.setMessage("successfully fetched into database");
			responceStructure.setData(managerDao.fetchManagerById(id));
			return new ResponseEntity<ResponceStructure<Manager>>(responceStructure, HttpStatus.FOUND);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Manager>> updateManager(int oldId, Manager manager) {
		Manager dbManager = managerDao.fetchManagerById(oldId);
		if (dbManager != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully updated in database");
			responceStructure.setData(managerDao.updateManager(oldId, manager));
			return new ResponseEntity<ResponceStructure<Manager>>(responceStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Manager>> deleteManagerById(int id) {
		Manager dbManager = managerDao.fetchManagerById(id);
		if (dbManager != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("successfully updated in database");
			responceStructure.setData(managerDao.deleteManagerById(id));
			return new ResponseEntity<ResponceStructure<Manager>>(responceStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}
}
