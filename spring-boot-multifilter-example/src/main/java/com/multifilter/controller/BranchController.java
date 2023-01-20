package com.multifilter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multifilter.dto.BranchDto;
import com.multifilter.entities.BranchEntity;
import com.multifilter.exception.response.EmptyResponseDto;
import com.multifilter.exception.response.ErrorResponseDto;
import com.multifilter.exception.response.SuccessResponseDto;
import com.multifilter.repo.BranchRepo;
import com.multifilter.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchRepo branchRepo;

	@Autowired
	private BranchService branchService;

	@PostMapping()
	public ResponseEntity<?> addBranch(@Valid @RequestBody BranchDto dto) {

		try {

			this.branchService.addBranch(dto);

			return new ResponseEntity<>(new SuccessResponseDto("success", "Success", null), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {

		List<BranchEntity> database = this.branchRepo.findAll();

		if (!database.isEmpty()) {

			try {

				List<BranchDto> list = this.branchService.getAllBranch();

				return new ResponseEntity<>(new SuccessResponseDto("success", "Success", list), HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.NOT_ACCEPTABLE);
			}

		} else {

			return new ResponseEntity<>(new EmptyResponseDto("dataNotFound", "Data Not Found"), HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/admin/all")
	public ResponseEntity<?> getAllAdmin() {

		List<BranchEntity> database = this.branchRepo.findAll();

		if (!database.isEmpty()) {

			try {

				List<BranchEntity> list = this.branchService.getAll();

				return new ResponseEntity<>(new SuccessResponseDto("success", "Success", list), HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.NOT_ACCEPTABLE);
			}

		} else {

			return new ResponseEntity<>(new EmptyResponseDto("dataNotFound", "Data Not Found"), HttpStatus.NOT_FOUND);

		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editBranch(@Valid @RequestParam(value = "id") long id, @RequestBody BranchDto BranchDto) {

		List<BranchEntity> database = this.branchRepo.findAll();

		if (!database.isEmpty()) {

			try {

				this.branchService.editBranch(id, BranchDto);

				return new ResponseEntity<>(new SuccessResponseDto("success", "Success", null), HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.NOT_ACCEPTABLE);
			}

		} else {

			return new ResponseEntity<>(new EmptyResponseDto("dataNotFound", "Data Not Found"), HttpStatus.NOT_FOUND);

		}

	}

	@DeleteMapping
	public ResponseEntity<?> deleteBranch(@Valid @RequestParam(value = "id") long id) {

		List<BranchEntity> database = this.branchRepo.findAll();

		if (!database.isEmpty()) {

			try {

				this.branchService.deleteBranch(id);

				return new ResponseEntity<>(
						new SuccessResponseDto("success", "Success", "id = " + id + " deleted successfully"),
						HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.NOT_ACCEPTABLE);
			}

		} else {

			return new ResponseEntity<>(new EmptyResponseDto("dataNotFound", "Data Not Found"), HttpStatus.NOT_FOUND);

		}

	}

}
