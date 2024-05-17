package com.project.Springboot_Resort_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Springboot_Resort_Management.dto.Manager;
import com.project.Springboot_Resort_Management.repo.ManagerRepo;

@Repository
public class ManagerDao {
	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}

	public Manager fetchManagerById(int id) {
		Optional<Manager> dbManager = managerRepo.findById(id);
		if (dbManager.isPresent()) {
			return dbManager.get();
		} else {
			return null;
		}
	}

	public Manager updateManager(int oldId, Manager manager) {
		Optional<Manager> dbManager = managerRepo.findById(oldId);
		if (dbManager.isPresent()) {
			manager.setManagerId(oldId);
			return managerRepo.save(manager);
		} else {
			return null;
		}
	}

	public Manager deleteManagerById(int id) {
		Optional<Manager> dbManager = managerRepo.findById(id);
		if (dbManager.isPresent()) {
			Manager manager = managerRepo.findById(id).get();
			managerRepo.delete(manager);
			return manager;
		} else {
			return null;
		}
	}
}
