package com.project.Springboot_Resort_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Springboot_Resort_Management.dao.AddressDao;
import com.project.Springboot_Resort_Management.dao.BranchDao;
import com.project.Springboot_Resort_Management.dao.EmployeeDao;
import com.project.Springboot_Resort_Management.dao.ManagerDao;
import com.project.Springboot_Resort_Management.dao.RoomDao;
import com.project.Springboot_Resort_Management.dto.Address;
import com.project.Springboot_Resort_Management.dto.Branch;
import com.project.Springboot_Resort_Management.dto.Employee;
import com.project.Springboot_Resort_Management.dto.Manager;
import com.project.Springboot_Resort_Management.dto.Room;
import com.project.Springboot_Resort_Management.exception.AddressIdNotFound;
import com.project.Springboot_Resort_Management.exception.BranchIdNotFound;
import com.project.Springboot_Resort_Management.exception.EmployeeIdNotFound;
import com.project.Springboot_Resort_Management.exception.ManagerIdNotFound;
import com.project.Springboot_Resort_Management.exception.RoomIdNotFound;
import com.project.Springboot_Resort_Management.util.ResponceStructure;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	RoomDao roomDao;

	@Autowired
	ResponceStructure<Branch> responceStructure;

	public ResponseEntity<ResponceStructure<Branch>> saveBranch(Branch branch) {

		responceStructure.setStatusId(HttpStatus.CREATED.value());
		responceStructure.setMessage("Successfully inserted into DataBase");
		responceStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructure<Branch>> fetchBranchById(int id) {
		Branch dbBranch = branchDao.fetchBranchById(id);
		if (dbBranch != null) {
			responceStructure.setStatusId(HttpStatus.FOUND.value());
			responceStructure.setMessage("Successfully fetched into DataBase");
			responceStructure.setData(branchDao.fetchBranchById(id));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.FOUND);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Branch>> updateBranch(int oldId, Branch branch) {
		Branch dbBranch = branchDao.fetchBranchById(oldId);
		if (dbBranch != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully updated in DataBase");
			responceStructure.setData(branchDao.updateBranch(oldId, branch));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Branch>> deleteBranchById(int id) {
		Branch dbBranch = branchDao.fetchBranchById(id);
		if (dbBranch != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully deleted into DataBase");
			responceStructure.setData(branchDao.deleteBranchById(id));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Branch>> addExistingAddressToExistingBranch(int oldBranchId,int oldAddressId) {
		Branch dbBranch = branchDao.fetchBranchById(oldBranchId);
		Address dbAddress=addressDao.fetchAddressById(oldAddressId);
		if (dbBranch != null && dbAddress!=null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully add Existing Address To ExistingBranch in DataBase");
			responceStructure.setData(branchDao.addExistingAddressToExistingBranch(oldBranchId, oldAddressId));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.OK);
		} else if(dbBranch == null){
			throw new BranchIdNotFound();
		}
		else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Branch>> addNewAddressToExistingBranch(int oldBranchId, Address address) {
		Branch dbBranch = branchDao.fetchBranchById(oldBranchId);
		if (dbBranch != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully add New Address To Existing Branch in DataBase");
			responceStructure.setData(branchDao.addNewAddressToExistingBranch(oldBranchId, address));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Branch>> addExistingManagerToExistingBranch(int oldBranchId,int oldManagerId) {
		Branch dbBranch = branchDao.fetchBranchById(oldBranchId);
		Manager dbManager=managerDao.fetchManagerById(oldManagerId);
		if (dbBranch != null && dbManager!=null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully add Existing Manager To Existing Branch in DataBase");
			responceStructure.setData(branchDao.addExistingManagerToExistingBranch(oldBranchId, oldManagerId));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.OK);
		} else if(dbBranch == null){
			throw new BranchIdNotFound();
		}
		else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Branch>> addNewManagerToExistingBranch(int oldBranchId, Manager manager) {
		Branch dbBranch = branchDao.fetchBranchById(oldBranchId);
		if (dbBranch != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully add New Manager To Existing Branch in DataBase");
			responceStructure.setData(branchDao.addNewManagerToExistingBranch(oldBranchId, manager));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Branch>> addExistingEmployeeToExistingBranch(int oldBranchId,int oldEmployeeId) {
		Branch dbBranch = branchDao.fetchBranchById(oldBranchId);
		Employee dbEmployee=employeeDao.fetchEmployeeById(oldEmployeeId);
		if (dbBranch != null && dbEmployee!=null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully add Existing Employee To Existing Branch in DataBase");
			responceStructure.setData(branchDao.addExistingEmployeeToExistingBranch(oldBranchId, oldEmployeeId));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.OK);
		} else if(dbBranch == null){
			throw new BranchIdNotFound();
		}
		else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Branch>> addNewEmployeeToExistingBranch(int oldBranchId,
			Employee employee) {
		Branch dbBranch = branchDao.fetchBranchById(oldBranchId);
		if (dbBranch != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully add New Employee To Existing Branch in DataBase");
			responceStructure.setData(branchDao.addNewEmployeeToExistingBranch(oldBranchId, employee));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Branch>> addExistingRoomToExistingBranch(int oldBranchId, int oldRoomId) {
		Branch dbBranch = branchDao.fetchBranchById(oldBranchId);
		Room dbRoom=roomDao.fetchRoomById(oldRoomId);
		if (dbBranch != null && dbRoom!=null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully add Existing Room To Existing Branch in DataBase");
			responceStructure.setData(branchDao.addExistingRoomToExistingBranch(oldBranchId, oldRoomId));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.OK);
		} else if(dbBranch==null){
			throw new BranchIdNotFound();
		}
		else {
			throw new RoomIdNotFound();
		}
	}

	public ResponseEntity<ResponceStructure<Branch>> addNewRoomToExistingBranch(int oldBranchId, Room room) {
		Branch dbBranch = branchDao.fetchBranchById(oldBranchId);
		if (dbBranch != null) {
			responceStructure.setStatusId(HttpStatus.OK.value());
			responceStructure.setMessage("Successfully add New Room To Existing Branch in DataBase");
			responceStructure.setData(branchDao.addNewRoomToExistingBranch(oldBranchId, room));
			return new ResponseEntity<ResponceStructure<Branch>>(responceStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}
}
