package com.multifilter.service;

import java.util.List;

import com.multifilter.dto.EmployeeDto;
import com.multifilter.entities.EmployeeEntity;
import com.multifilter.exception.EmployeeNotFoundException;

public interface EmployeeService {

	List<EmployeeDto> getAllEmployeee();

	List<EmployeeEntity> findByDepartmentIdAndBranchIdAndDesignationId(List<Integer> departmentId,
			List<Integer> branchId, List<Integer> designationId);

	void addEmployee(EmployeeDto employeeDto);

	List<EmployeeEntity> findBySearch(String search);

	List<EmployeeEntity> getAll();

	void editEmployee(long id, EmployeeDto employeeDto) throws EmployeeNotFoundException;

	void deleteEmployee(long id);

}
