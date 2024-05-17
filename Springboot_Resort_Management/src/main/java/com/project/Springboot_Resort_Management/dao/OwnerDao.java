package com.project.Springboot_Resort_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Springboot_Resort_Management.dto.Owner;
import com.project.Springboot_Resort_Management.dto.Resort;
import com.project.Springboot_Resort_Management.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	ResortDao resortDao;
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner fetchOwnerById(int id) {
		Optional<Owner> dbOwner=ownerRepo.findById(id);
		if(dbOwner.isPresent()) {
		return ownerRepo.findById(id).get();
		}
		else {
			return null;
		}
	}
	
	public Owner updateOwner(int oldId,Owner owner) {
		Optional<Owner> dbOwner=ownerRepo.findById(oldId);
		if(dbOwner.isPresent()) {
			owner.setOwnerId(oldId);
			return ownerRepo.save(owner);
		}
		else {
			return null;
		}
		
	}
	
	public Owner deleteOwnerById(int id) {
		Optional<Owner> dbOwner=ownerRepo.findById(id);
		if(dbOwner.isPresent()) {
		Owner owner=dbOwner.get();
		ownerRepo.delete(owner);
		return owner;
		}
		else {
			return null;
		}
	}
	
	public Owner addExistingResortToExistingOwner(int oldOwnerId,int oldResortId) {
		Optional<Owner> dbOwner=ownerRepo.findById(oldOwnerId);
		if(dbOwner.isPresent()) {
		Owner owner=dbOwner.get();
		Resort resort=resortDao.fetchResortById(oldResortId);
		List<Resort> list=owner.getResorts();
		list.add(resort);
		// owner.getResorts().add(resort);
		return ownerRepo.save(owner);
		}
		else {
			return null;
		}
	}
	public Owner addNewResortToExistingOwner(int oldOwnerId,Resort resort) {
		Optional<Owner> dbOwner=ownerRepo.findById(oldOwnerId);
		if(dbOwner.isPresent()) {
		Owner owner=dbOwner.get();
		List<Resort> list=owner.getResorts();
		list.add(resort);
		// owner.getResorts().add(resort);
		return ownerRepo.save(owner);
		}
		else {
			return null;
		}
	}
}
