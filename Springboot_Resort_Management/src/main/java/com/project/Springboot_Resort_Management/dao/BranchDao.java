package com.project.Springboot_Resort_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Springboot_Resort_Management.dto.Address;
import com.project.Springboot_Resort_Management.dto.Branch;
import com.project.Springboot_Resort_Management.dto.Employee;
import com.project.Springboot_Resort_Management.dto.Manager;
import com.project.Springboot_Resort_Management.dto.Room;
import com.project.Springboot_Resort_Management.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;

	@Autowired
	AddressDao addressDao;

	@Autowired
	ManagerDao managerDao;

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	RoomDao roomDao;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch fetchBranchById(int id) {
		Optional<Branch> dbBranch = branchRepo.findById(id);
		if (dbBranch.isPresent()) {
			return dbBranch.get();
		} else {
			return null;
		}
	}

	public Branch updateBranch(int oldId, Branch branch) {
		Optional<Branch> dbBranch = branchRepo.findById(oldId);
		if (dbBranch != null) {
			branch.setBranchId(oldId);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch deleteBranchById(int id) {
		Optional<Branch> dbBranch = branchRepo.findById(id);
		if (dbBranch != null) {
			Branch branch = branchRepo.findById(id).get();
			branchRepo.delete(branch);
			return branch;
		} else {
			return null;
		}
	}

	public Branch addExistingAddressToExistingBranch(int oldBranchId, int oldAddressId) {
		Optional<Branch> dbBranch = branchRepo.findById(oldBranchId);
		if (dbBranch != null) {
			Branch branch = fetchBranchById(oldBranchId);
			Address address = addressDao.fetchAddressById(oldAddressId);
			branch.setAddress(address);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch addNewAddressToExistingBranch(int oldBranchId, Address address) {
		Optional<Branch> dbBranch = branchRepo.findById(oldBranchId);
		if (dbBranch != null) {
			Branch branch = fetchBranchById(oldBranchId);
			branch.setAddress(address);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch addExistingManagerToExistingBranch(int oldBranchId, int oldManagerId) {
		Optional<Branch> dbBranch = branchRepo.findById(oldBranchId);
		if (dbBranch != null) {
			Branch branch = fetchBranchById(oldBranchId);
			Manager manager = managerDao.fetchManagerById(oldManagerId);
			branch.setManager(manager);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch addNewManagerToExistingBranch(int oldBranchId, Manager manager) {
		Optional<Branch> dbBranch = branchRepo.findById(oldBranchId);
		if (dbBranch != null) {
			Branch branch = fetchBranchById(oldBranchId);
			managerDao.saveManager(manager);
			branch.setManager(manager);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch addExistingEmployeeToExistingBranch(int oldBranchId, int oldEmployeeId) {
		Optional<Branch> dbBranch = branchRepo.findById(oldBranchId);
		if (dbBranch != null) {
			Branch branch = fetchBranchById(oldBranchId);
			Employee employee = employeeDao.fetchEmployeeById(oldEmployeeId);
			List<Employee> list = branch.getEmployee();
			list.add(employee);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch addNewEmployeeToExistingBranch(int oldBranchId, Employee employee) {
		Optional<Branch> dbBranch = branchRepo.findById(oldBranchId);
		if (dbBranch != null) {
			Branch branch = fetchBranchById(oldBranchId);
			List<Employee> list = branch.getEmployee();
			list.add(employee);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch addExistingRoomToExistingBranch(int oldBranchId, int oldRoomId) {
		Optional<Branch> dbBranch = branchRepo.findById(oldBranchId);
		if (dbBranch != null) {
			Branch branch = fetchBranchById(oldBranchId);
			Room room = roomDao.fetchRoomById(oldRoomId);
			List<Room> list = branch.getRoom();
			list.add(room);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch addNewRoomToExistingBranch(int oldBranchId, Room room) {
		Optional<Branch> dbBranch = branchRepo.findById(oldBranchId);
		if (dbBranch != null) {
			Branch branch = fetchBranchById(oldBranchId);
			List<Room> list = branch.getRoom();
			list.add(room);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

}
