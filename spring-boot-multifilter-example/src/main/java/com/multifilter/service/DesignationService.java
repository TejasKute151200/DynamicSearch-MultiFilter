package com.multifilter.service;

import java.util.List;

import com.multifilter.dto.DesignationDto;
import com.multifilter.entities.DesignationEntity;
import com.multifilter.exception.DesignationNotFoundException;

public interface DesignationService {

	List<DesignationDto> getAllDesignation();

	void addDesignation(DesignationDto dto);

	void editDesignation(long id, DesignationDto dto) throws DesignationNotFoundException;

	List<DesignationEntity> getAll();

	void deleteDesignation(long id);

}
