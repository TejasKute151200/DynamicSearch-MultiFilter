package com.multifilter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multifilter.dto.DesignationDto;
import com.multifilter.entities.DesignationEntity;
import com.multifilter.exception.DesignationNotFoundException;
import com.multifilter.repo.DesignationRepo;
import com.multifilter.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationRepo designationRepo;

	@Override
	public void addDesignation(DesignationDto dto) {

		DesignationEntity designation = new DesignationEntity();

		designation.setDesignationName(dto.getDesignationName());

		this.designationRepo.save(designation);
	}

	@Override
	public List<DesignationDto> getAllDesignation() {

		List<DesignationEntity> entities = this.designationRepo.findAll();
		List<DesignationDto> dtos = new ArrayList<>();

		for (int i = 0; i < entities.size(); i++) {

			DesignationDto designationDto = new DesignationDto();

			designationDto.setDesignationName(entities.get(i).getDesignationName());

			dtos.add(designationDto);

		}

		return dtos;

	}

	@Override
	public List<DesignationEntity> getAll() {

		return this.designationRepo.findAllAdmin();
	}

	@Override
	public void editDesignation(long id, DesignationDto dto) throws DesignationNotFoundException {

		DesignationEntity updateDesignation = this.designationRepo.findById(id)
				.orElseThrow(() -> new DesignationNotFoundException("Designation with id " + id + " not found."));

		updateDesignation.setDesignationName(dto.getDesignationName());

		this.designationRepo.save(updateDesignation);

	}

	@Override
	public void deleteDesignation(long id) {
		this.designationRepo.deleteById(id);
	}

}
