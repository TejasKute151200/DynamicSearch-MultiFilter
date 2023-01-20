package com.multifilter.dto;

import javax.validation.constraints.Email;
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

	@Email(message = "Email is Not Valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
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
