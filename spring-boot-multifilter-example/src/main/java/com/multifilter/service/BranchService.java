package com.multifilter.service;

import java.util.List;

import com.multifilter.dto.BranchDto;
import com.multifilter.entities.BranchEntity;
import com.multifilter.exception.BranchNotFoundException;

public interface BranchService {

	List<BranchDto> getAllBranch();

	void deleteBranch(long id);

	void editBranch(long id, BranchDto dto) throws BranchNotFoundException;

	List<BranchEntity> getAll();

	void addBranch(BranchDto dto);

}
