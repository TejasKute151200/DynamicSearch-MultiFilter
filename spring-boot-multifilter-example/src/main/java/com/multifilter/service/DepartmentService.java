package com.multifilter.service;

import java.util.List;

import com.multifilter.dto.DepartmentDto;
import com.multifilter.entities.DepartmentEntity;
import com.multifilter.exception.DepartmentNotFoundException;

public interface DepartmentService {

	void addDepartment(DepartmentDto dto);

	void editDepartment(long id, DepartmentDto dto) throws DepartmentNotFoundException;

	List<DepartmentEntity> getAll();

	List<DepartmentDto> getAllDepartment();

	void deleteDepartment(long id);

}
