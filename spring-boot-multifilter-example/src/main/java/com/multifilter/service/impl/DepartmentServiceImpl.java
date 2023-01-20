package com.multifilter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multifilter.dto.DepartmentDto;
import com.multifilter.entities.DepartmentEntity;
import com.multifilter.exception.DepartmentNotFoundException;
import com.multifilter.repo.DepartmentRepo;
import com.multifilter.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public void addDepartment(DepartmentDto dto) {

		DepartmentEntity department = new DepartmentEntity();

		department.setDepartmentName(dto.getDepartmentName());

		this.departmentRepo.save(department);
	}

	@Override
	public List<DepartmentDto> getAllDepartment() {

		List<DepartmentEntity> entities = this.departmentRepo.findAll();
		List<DepartmentDto> dtos = new ArrayList<>();

		for (int i = 0; i < entities.size(); i++) {

			DepartmentDto departmentDto = new DepartmentDto();

			departmentDto.setDepartmentName(entities.get(i).getDepartmentName());

			dtos.add(departmentDto);

		}

		return dtos;

	}

	@Override
	public List<DepartmentEntity> getAll() {

		return this.departmentRepo.findAllAdmin();
	}

	@Override
	public void editDepartment(long id, DepartmentDto dto) throws DepartmentNotFoundException {

		DepartmentEntity updateDepartment = this.departmentRepo.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department with id " + id + " not found."));

		updateDepartment.setDepartmentName(dto.getDepartmentName());

		this.departmentRepo.save(updateDepartment);

	}

	@Override
	public void deleteDepartment(long id) {
		this.departmentRepo.deleteById(id);
	}

}
