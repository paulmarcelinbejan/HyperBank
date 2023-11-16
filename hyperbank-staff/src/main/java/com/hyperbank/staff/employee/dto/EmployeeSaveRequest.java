package com.hyperbank.staff.employee.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.utils.jackson.deserializer.LocalDateDeserializer;
import com.paulmarcelinbejan.toolbox.utils.jackson.serializer.LocalDateSerializer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeSaveRequest {
	
	@JsonProperty
	@NotNull(message = "nationalityId must not be null")
	private Integer nationalityId;

	@JsonProperty
	@NotNull(message = "residenceId must not be null")
	private Long residenceId;

	@JsonProperty
	@NotNull(message = "sexTypeId must not be null")
	private Integer sexTypeId;

	@JsonProperty
	@NotNull(message = "bankBranchId must not be null")
	private Integer bankBranchId;

	@JsonProperty
	@NotNull(message = "birthDate must not be null")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate birthDate;

	@JsonProperty
	@NotBlank(message = "name must not be blank")
	private String name;

	@JsonProperty
	@NotBlank(message = "surname must not be blank")
	private String surname;

	@JsonProperty
	@NotBlank(message = "email must not be blank")
	private String email;

	@JsonProperty
	@NotBlank(message = "phoneNumber must not be blank")
	private String phoneNumber;

}
