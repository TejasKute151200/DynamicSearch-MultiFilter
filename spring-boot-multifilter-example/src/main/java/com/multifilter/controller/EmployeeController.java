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

import com.multifilter.dto.EmployeeDto;
import com.multifilter.entities.EmployeeEntity;
import com.multifilter.exception.response.EmptyResponseDto;
import com.multifilter.exception.response.ErrorResponseDto;
import com.multifilter.exception.response.SuccessResponseDto;
import com.multifilter.repo.EmployeeRepo;
import com.multifilter.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private EmployeeService employeeService;

	@PostMapping()
	public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDto dto) {

		try {

			this.employeeService.addEmployee(dto);

			return new ResponseEntity<>(new SuccessResponseDto("success", "Success", null), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {

		List<EmployeeEntity> database = this.employeeRepo.findAll();

		if (!database.isEmpty()) {

			try {

				List<EmployeeDto> list = this.employeeService.getAllEmployeee();

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

		List<EmployeeEntity> database = this.employeeRepo.findAll();

		if (!database.isEmpty()) {

			try {

				List<EmployeeEntity> list = this.employeeService.getAll();

				return new ResponseEntity<>(new SuccessResponseDto("success", "Success", list), HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.NOT_ACCEPTABLE);
			}

		} else {

			return new ResponseEntity<>(new EmptyResponseDto("dataNotFound", "Data Not Found"), HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/filter")
	public ResponseEntity<?> getEmployeeByFilter(
			@RequestParam(value = "departmentId", required = true) List<Integer> departmentId,
			@RequestParam(value = "branchId", required = true) List<Integer> branchId,
			@RequestParam(value = "designationId", required = true) List<Integer> designationId) {

		List<EmployeeEntity> database = this.employeeRepo.findAll();

		if (!database.isEmpty()) {

			try {
				List<EmployeeEntity> employees = employeeService
						.findByDepartmentIdAndBranchIdAndDesignationId(departmentId, branchId, designationId);

				if (employees != null && !employees.isEmpty()) {

					return new ResponseEntity<>(new SuccessResponseDto("success", "Success", employees), HttpStatus.OK);

				} else {

					return new ResponseEntity<>(new EmptyResponseDto("dataNotFound", "Data Not Found"),
							HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {

				return new ResponseEntity<>(new ErrorResponseDto("Something Went Wrong", e.getMessage()),
						HttpStatus.NOT_ACCEPTABLE);
			}

		} else {

			return new ResponseEntity<>(new EmptyResponseDto("dataNotFound", "Data Not Found"), HttpStatus.NOT_FOUND);

		}
	}

	@GetMapping()
	public ResponseEntity<?> getAll(@Valid @RequestParam(value = "search", required = false) String search) {

		List<EmployeeEntity> database = this.employeeRepo.findAll();

		if (!database.isEmpty()) {

			try {

				List<EmployeeEntity> list = this.employeeService.findBySearch(search);

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
	public ResponseEntity<?> editEmployee(@Valid @RequestParam(value = "id") long id,@Valid @RequestBody EmployeeDto employeeDto) {

		List<EmployeeEntity> database = this.employeeRepo.findAll();

		if (!database.isEmpty()) {

			try {

				this.employeeService.editEmployee(id, employeeDto);

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
	public ResponseEntity<?> deleteEmployee(@Valid @RequestParam(value = "id") long id) {

		List<EmployeeEntity> database = this.employeeRepo.findAll();

		if (!database.isEmpty()) {

			try {

				this.employeeService.deleteEmployee(id);

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
