package com.hyperbank.accounts.customerindividual.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hyperbank.commons.sextype.dto.SexTypeResponse;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateSerializer;

import lombok.Data;

@Data
public class CustomerIndividualResponse {

	@JsonProperty
	private Long id;

	@JsonProperty
	private Integer fkNationality;

	@JsonProperty
	private Long fkResidence;

	@JsonProperty
	private SexTypeResponse sexType;

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