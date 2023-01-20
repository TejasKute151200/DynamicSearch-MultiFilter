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
public class BranchDto {

	@NotEmpty(message = "branchName Can Not Be Null Or Empty*branchNameRequired")
	@NotBlank(message = "branchName Can Not Be Null Or Blank*branchNameRequired")
	private String branchName;

}
