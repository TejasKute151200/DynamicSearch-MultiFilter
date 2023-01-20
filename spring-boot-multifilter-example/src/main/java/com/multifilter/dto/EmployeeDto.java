package com.multifilter.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.multifilter.entities.BranchEntity;
import com.multifilter.entities.DepartmentEntity;
import com.multifilter.entities.DesignationEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {

	@NotEmpty(message = "employeeName Can Not Be Null Or Empty*employeeNameRequired")
	@NotBlank(message = "employeeName Can Not Be Null Or Blank*employeeNameRequired")
	private String employeeName;

	@NotNull(message = "salary Can Not Be Null*salaryRequired")
	private double salary;

	@NotEmpty(message = "Email Can Not Be Null Or Empty*emailRequired")
	@NotBlank(message = "Email Can Not Be Null Or Blank*emailRequired")
	private String email;

	@NotEmpty(message = "mobile Can Not Be Null Or Empty*mobileRequired")
	@NotBlank(message = "mobile Can Not Be Null Or Blank*mobileRequired")
	private String mobile;

	@NotEmpty(message = "address Can Not Be Null Or Empty*addressRequired")
	@NotBlank(message = "address Can Not Be Null Or Blank*addressRequired")
	private String address;

	@NotNull(message = "pincode Can Not Be Null*pincodeRequired")
	private double pincode;

	private BranchEntity branch;

	private DepartmentEntity department;

	private DesignationEntity designation;

}
