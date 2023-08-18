package com.hyperbank.accounts.customerindividual.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.hyperbank.commons.sextype.dto.SexTypeDto;

import lombok.Data;

@Data
public class CustomerIndividualDto {

	@JsonProperty
	private Long id;

	@JsonProperty
	private Integer fkNationality;

	@JsonProperty
	private Long fkResidence;

	@JsonProperty
	private SexTypeDto sexType;

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
	
	public interface CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation {
		// validation group marker interface
	}

}