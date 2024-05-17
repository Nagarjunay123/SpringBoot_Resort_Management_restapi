package com.project.Springboot_Resort_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Springboot_Resort_Management.dao.BranchDao;
import com.project.Springboot_Resort_Management.dao.ResortDao;
import com.project.Springboot_Resort_Management.dto.Branch;
import com.project.Springboot_Resort_Management.dto.Resort;
import com.project.Springboot_Resort_Management.exception.BranchIdNotFound;
import com.project.Springboot_Resort_Management.exception.ResortIdNotFound;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@Service
public class ResortService {

	@Autowired
	ResortDao resortDao;
	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponceStructure<Resort> responceStructure;
	
	public ResponseEntity<ResponceStructure<Resort>> saveResort(Resort resort) {
		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("successfully inserted into database");
		responceStructure.setData(resortDao.saveResort(resort));
		return new ResponseEntity<ResponceStructure<Resort>>(responceStructure, HttpStatus.CREATED) ;
		}
	
	public ResponseEntity<ResponceStructure<Resort>> fetchResortById(int id) {
		Resort dbResort=resortDao.fetchResortById(id);
		if(dbResort!=null) {
		responceStructure.setStatusId(HttpStatus.FOUND.value());
		responceStructure.setMessage("successfully fetched into database");
		responceStructure.setData(resortDao.fetchResortById(id));
		return new ResponseEntity<ResponceStructure<Resort>>(responceStructure, HttpStatus.FOUND) ;
		}
		else {
			throw new ResortIdNotFound();
		}
	}
	
	public ResponseEntity<ResponceStructure<Resort>> updateResort(int oldId,Resort resort) {
		Resort dbResort=resortDao.fetchResortById(oldId);
		if(dbResort!=null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully updated into database");
		responceStructure.setData(resortDao.updateResort(oldId, resort));
		return new ResponseEntity<ResponceStructure<Resort>>(responceStructure, HttpStatus.OK) ;
		}
		else {
			throw new ResortIdNotFound();
		}
	}
	public ResponseEntity<ResponceStructure<Resort>> deleteResortById(int id) {
		Resort dbResort=resortDao.fetchResortById(id);
		if(dbResort!=null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully deleted into database");
		responceStructure.setData(resortDao.deleteResortById(id));
		return new ResponseEntity<ResponceStructure<Resort>>(responceStructure, HttpStatus.OK) ;
		}
		else {
			throw new ResortIdNotFound();
		}
	}
	public ResponseEntity<ResponceStructure<Resort>> addExistingBrachToExistingResort(int oldResort,int oldBranch) {
		Resort dbResort=resortDao.fetchResortById(oldResort);
		Branch dbBranch=branchDao.fetchBranchById(oldBranch);
		if(dbResort!=null && dbBranch!=null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully add Existing Brach To Existing Resort into database");
		responceStructure.setData(resortDao.addExistingBrachToExistingResort(oldResort, oldBranch));
		return new ResponseEntity<ResponceStructure<Resort>>(responceStructure, HttpStatus.OK) ;
		}else if(dbResort==null){
			throw new ResortIdNotFound();
		}
		else {
			throw new BranchIdNotFound();
		}
	}
	public ResponseEntity<ResponceStructure<Resort>> addNewBrachToExistingResort(int oldResort,Branch branch) {
		Resort dbResort=resortDao.fetchResortById(oldResort);
		if(dbResort!=null) {
		responceStructure.setStatusId(HttpStatus.OK.value());
		responceStructure.setMessage("successfully add New Brach To Existing Resort into database");
		responceStructure.setData(resortDao.addNewBrachToExistingResort(oldResort, branch));
		return new ResponseEntity<ResponceStructure<Resort>>(responceStructure, HttpStatus.OK) ;
		}
		else {
			throw new ResortIdNotFound();
		}
	}
}
