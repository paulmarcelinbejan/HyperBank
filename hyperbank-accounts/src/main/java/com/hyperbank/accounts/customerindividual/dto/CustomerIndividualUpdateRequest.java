package com.hyperbank.accounts.customerindividual.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateSerializer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerIndividualUpdateRequest {

	@JsonProperty
	@NotNull(message = "id must not be null")
	private Long id;

	@JsonProperty
	@NotNull(message = "fkNationality must not be null")
	private Integer fkNationality;

	@JsonProperty
	@NotNull(message = "fkResidence must not be null")
	private Long fkResidence;

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