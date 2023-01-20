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
public class DesignationDto {

	@NotEmpty(message = "designationName Can Not Be Null Or Empty*designationNameRequired")
	@NotBlank(message = "designationName Can Not Be Null Or Blank*designationNameRequired")
	private String designationName;

}
