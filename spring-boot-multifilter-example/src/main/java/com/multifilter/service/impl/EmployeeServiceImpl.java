package com.multifilter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multifilter.dto.EmployeeDto;
import com.multifilter.entities.EmployeeEntity;
import com.multifilter.exception.EmployeeNotFoundException;
import com.multifilter.repo.EmployeeRepo;
import com.multifilter.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void addEmployee(EmployeeDto employeeDto) {

		EmployeeEntity entity = new EmployeeEntity();

		entity.setEmployeeName(employeeDto.getEmployeeName());
		entity.setSalary(employeeDto.getSalary());
		entity.setEmail(employeeDto.getEmail());
		entity.setMobile(employeeDto.getMobile());
		entity.setAddress(employeeDto.getAddress());
		entity.setPincode(employeeDto.getPincode());

		entity.setDepartment((employeeDto.getDepartment()));
		entity.setDesignation(employeeDto.getDesignation());
		entity.setBranch(employeeDto.getBranch());

		this.employeeRepo.save(entity);

		return;

	}

	@Override
	public List<EmployeeDto> getAllEmployeee() {

		List<EmployeeEntity> entities = this.employeeRepo.findAll();
		List<EmployeeDto> dtos = new ArrayList<>();

		for (int i = 0; i < entities.size(); i++) {

			EmployeeDto employeeDto = new EmployeeDto();

			employeeDto.setEmployeeName(entities.get(i).getEmployeeName());

			employeeDto.setSalary(entities.get(i).getSalary());
			employeeDto.setEmail(entities.get(i).getEmail());
			employeeDto.setMobile(entities.get(i).getMobile());
			employeeDto.setAddress(entities.get(i).getAddress());
			employeeDto.setPincode(entities.get(i).getPincode());

			employeeDto.setBranch(entities.get(i).getBranch());
			employeeDto.setDepartment(entities.get(i).getDepartment());
			employeeDto.setDesignation(entities.get(i).getDesignation());

			dtos.add(employeeDto);

		}

		return dtos;

	}

	@Override
	public List<EmployeeEntity> getAll() {
		return this.employeeRepo.findAllAdmin();
	}

	@Override
	public void editEmployee(long id, EmployeeDto employeeDto) throws EmployeeNotFoundException {

		EmployeeEntity updateEmployee = this.employeeRepo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found."));

		updateEmployee.setEmployeeName(employeeDto.getEmployeeName());
		updateEmployee.setSalary(employeeDto.getSalary());
		updateEmployee.setEmail(employeeDto.getEmail());
		updateEmployee.setMobile(employeeDto.getMobile());
		updateEmployee.setAddress(employeeDto.getAddress());
		updateEmployee.setPincode(employeeDto.getPincode());

		updateEmployee.setDepartment((employeeDto.getDepartment()));
		updateEmployee.setDesignation(employeeDto.getDesignation());
		updateEmployee.setBranch(employeeDto.getBranch());

		this.employeeRepo.save(updateEmployee);

		return;

	}

	@Override
	public void deleteEmployee(long id) {
		this.employeeRepo.deleteById(id);
	}

//	Filter
	@Override
	public List<EmployeeEntity> findByDepartmentIdAndBranchIdAndDesignationId(List<Integer> departmentId,
			List<Integer> branchId, List<Integer> designationId) {
		return this.employeeRepo.findByDepartmentIdAndBranchIdAndDesignationId(departmentId, branchId, designationId);
	}

//	Dynamic Search
	@Override
	public List<EmployeeEntity> findBySearch(String search) {
		return employeeRepo.findBySearch(search);
	}

}
