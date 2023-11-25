package com.hyperbank.accounts.customerindividual.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hyperbank.architecture.web.jackson.deserializer.LocalDateDeserializer;
import com.hyperbank.architecture.web.jackson.serializer.LocalDateSerializer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerIndividualSaveRequest {

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
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@NotNull(message = "birthDate must not be null")
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