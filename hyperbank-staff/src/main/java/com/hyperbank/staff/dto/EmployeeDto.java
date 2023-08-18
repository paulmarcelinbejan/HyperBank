package com.hyperbank.staff.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDto {

	private Long id;

	@NotNull
	private Integer fkNationality;

	@NotNull
	private Long fkResidence;

	@NotNull
	private Integer sexType;

	@NotNull
	private Integer fkBankBranch;

	@NotNull
	private LocalDate birthDate;

	@NotBlank
	private String name;

	@NotBlank
	private String surname;

	@NotBlank
	private String email;

	@NotBlank
	private String phoneNumber;

}
