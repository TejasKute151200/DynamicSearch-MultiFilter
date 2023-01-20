package com.multifilter.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDto {

	@NotEmpty(message = "departmentName Can Not Be Null Or Empty*departmentNameRequired")
	@NotBlank(message = "departmentName Can Not Be Null Or Blank*departmentNameRequired")
	private String departmentName;

}
