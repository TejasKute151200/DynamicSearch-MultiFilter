package com.multifilter.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multifilter.dto.BranchDto;
import com.multifilter.entities.BranchEntity;
import com.multifilter.exception.BranchNotFoundException;
import com.multifilter.repo.BranchRepo;
import com.multifilter.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepo branchRepo;

	@Override
	public void addBranch(BranchDto dto) {

		BranchEntity branch = new BranchEntity();

		branch.setBranchName(dto.getBranchName());

		this.branchRepo.save(branch);
	}

	@Override
	public List<BranchDto> getAllBranch() {

		List<BranchEntity> entities = this.branchRepo.findAll();
		List<BranchDto> dtos = new ArrayList<>();

		for (int i = 0; i < entities.size(); i++) {

			BranchDto branchDto = new BranchDto();

			branchDto.setBranchName(entities.get(i).getBranchName());

			dtos.add(branchDto);

		}

		return dtos;

	}

	@Override
	public List<BranchEntity> getAll() {

		return this.branchRepo.findAllAdmin();
	}

	@Override
	public void editBranch(long id, BranchDto dto) throws BranchNotFoundException {

		BranchEntity updateBranch = this.branchRepo.findById(id)
				.orElseThrow(() -> new BranchNotFoundException("Branch with id " + id + " not found."));

		updateBranch.setBranchName(dto.getBranchName());

		this.branchRepo.save(updateBranch);

	}

	@Override
	public void deleteBranch(long id) {
		this.branchRepo.deleteById(id);
	}

}
