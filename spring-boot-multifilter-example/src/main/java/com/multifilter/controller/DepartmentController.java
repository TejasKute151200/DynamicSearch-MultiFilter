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

import com.multifilter.dto.DepartmentDto;
import com.multifilter.entities.DepartmentEntity;
import com.multifilter.exception.response.EmptyResponseDto;
import com.multifilter.exception.response.ErrorResponseDto;
import com.multifilter.exception.response.SuccessResponseDto;
import com.multifilter.repo.DepartmentRepo;
import com.multifilter.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private DepartmentService departmentService;

	@PostMapping()
	public ResponseEntity<?> addDepartment(@Valid @RequestBody DepartmentDto dto) {

		try {

			this.departmentService.addDepartment(dto);

			return new ResponseEntity<>(new SuccessResponseDto("success", "Success", null), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {

		List<DepartmentEntity> database = this.departmentRepo.findAll();

		if (!database.isEmpty()) {

			try {

				List<DepartmentDto> list = this.departmentService.getAllDepartment();

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

		List<DepartmentEntity> database = this.departmentRepo.findAll();

		if (!database.isEmpty()) {

			try {

				List<DepartmentEntity> list = this.departmentService.getAll();

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
	public ResponseEntity<?> editDepartment(@Valid @RequestParam(value = "id") long id,
			@Valid @RequestBody DepartmentDto DepartmentDto) {

		List<DepartmentEntity> database = this.departmentRepo.findAll();

		if (!database.isEmpty()) {

			try {

				this.departmentService.editDepartment(id, DepartmentDto);

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
	public ResponseEntity<?> deleteDepartment(@Valid @RequestParam(value = "id") long id) {

		List<DepartmentEntity> database = this.departmentRepo.findAll();

		if (!database.isEmpty()) {

			try {

				this.departmentService.deleteDepartment(id);

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
