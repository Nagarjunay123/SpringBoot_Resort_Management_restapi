package com.project.Springboot_Resort_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Springboot_Resort_Management.dto.Branch;
import com.project.Springboot_Resort_Management.dto.Resort;
import com.project.Springboot_Resort_Management.repo.ResortRepo;

@Repository
public class ResortDao {

	@Autowired
	ResortRepo resortRepo;

	@Autowired
	BranchDao branchDao;

	public Resort saveResort(Resort resort) {
		return resortRepo.save(resort);
	}

	public Resort fetchResortById(int id) {
		Optional<Resort> dbResort = resortRepo.findById(id);
		if (dbResort.isPresent()) {
			return dbResort.get();
		} else {
			return null;
		}
	}

	public Resort updateResort(int oldId, Resort resort) {
		Optional<Resort> dbResort = resortRepo.findById(oldId);
		if (dbResort.isPresent()) {
			resort.setResortId(oldId);
			return resortRepo.save(resort);
		} else {
			return null;
		}
	}

	public Resort deleteResortById(int id) {
		Optional<Resort> dbResort = resortRepo.findById(id);
		if (dbResort.isPresent()) {
			Resort resort = dbResort.get();
			resortRepo.delete(resort);
			return resort;
		} else {
			return null;
		}
	}

	public Resort addExistingBrachToExistingResort(int oldResort, int oldBranch) {
		Optional<Resort> dbResort = resortRepo.findById(oldResort);
		if (dbResort.isPresent()) {
			Resort resort = fetchResortById(oldResort);
			Branch branch = branchDao.fetchBranchById(oldBranch);
			List<Branch> list = resort.getBranch();
			list.add(branch);
			return resortRepo.save(resort);
		} else {
			return null;
		}
	}

	public Resort addNewBrachToExistingResort(int oldResort, Branch branch) {
		Optional<Resort> dbResort = resortRepo.findById(oldResort);
		if (dbResort.isPresent()) {
			Resort resort = fetchResortById(oldResort);
			List<Branch> list = resort.getBranch();
			list.add(branch);
			return resortRepo.save(resort);
		} else {
			return null;
		}
	}
}
