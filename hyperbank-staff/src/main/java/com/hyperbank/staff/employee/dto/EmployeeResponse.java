package com.hyperbank.staff.employee.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.utils.jackson.deserializer.LocalDateDeserializer;
import com.paulmarcelinbejan.toolbox.utils.jackson.serializer.LocalDateSerializer;

import lombok.Data;

@Data
public class EmployeeResponse {

	@JsonProperty
	private Long id;

	@JsonProperty
	private Integer nationalityId;

	@JsonProperty
	private Long residenceId;

	@JsonProperty
	private Integer sexTypeId;

	@JsonProperty
	private Integer bankBranchId;

	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate birthDate;

	@JsonProperty
	private String name;

	@JsonProperty
	private String surname;

	@JsonProperty
	private String email;

	@JsonProperty
	private String phoneNumber;

}
