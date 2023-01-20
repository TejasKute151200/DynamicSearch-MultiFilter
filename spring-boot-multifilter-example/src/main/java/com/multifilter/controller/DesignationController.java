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

import com.multifilter.dto.DesignationDto;
import com.multifilter.entities.DesignationEntity;
import com.multifilter.exception.response.EmptyResponseDto;
import com.multifilter.exception.response.ErrorResponseDto;
import com.multifilter.exception.response.SuccessResponseDto;
import com.multifilter.repo.DesignationRepo;
import com.multifilter.service.DesignationService;

@RestController
@RequestMapping("/designation")
public class DesignationController {

	@Autowired
	private DesignationRepo designationRepo;

	@Autowired
	private DesignationService designationService;

	@PostMapping()
	public ResponseEntity<?> addDesignation(@Valid @RequestBody DesignationDto dto) {

		try {

			this.designationService.addDesignation(dto);

			return new ResponseEntity<>(new SuccessResponseDto("success", "Success", null), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {

		List<DesignationEntity> database = this.designationRepo.findAll();

		if (!database.isEmpty()) {

			try {

				List<DesignationDto> list = this.designationService.getAllDesignation();

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

		List<DesignationEntity> database = this.designationRepo.findAll();

		if (!database.isEmpty()) {

			try {

				List<DesignationEntity> list = this.designationService.getAll();

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
	public ResponseEntity<?> editDesignation(@Valid @RequestParam(value = "id") long id,
			@Valid @RequestBody DesignationDto DesignationDto) {

		List<DesignationEntity> database = this.designationRepo.findAll();

		if (!database.isEmpty()) {

			try {

				this.designationService.editDesignation(id, DesignationDto);

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
	public ResponseEntity<?> deleteDesignation(@Valid @RequestParam(value = "id") long id) {

		List<DesignationEntity> database = this.designationRepo.findAll();

		if (!database.isEmpty()) {

			try {

				this.designationService.deleteDesignation(id);

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
