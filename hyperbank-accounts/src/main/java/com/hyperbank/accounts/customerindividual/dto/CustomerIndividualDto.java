package com.hyperbank.accounts.customerindividual.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hyperbank.commons.sextype.dto.SexTypeDto;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateSerializer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CustomerIndividualDto {

	@JsonProperty
	@Null(groups = { CreateValidation.class }, message = "id must be null")
	@NotNull(groups = { UpdateValidation.class }, message = "id must not be null")
	private Long id;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "fkNationality must not be null")
	private Integer fkNationality;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "fkResidence must not be null")
	private Long fkResidence;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "sexType must not be null")
	private SexTypeDto sexType;

	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "birthDate must not be null")
	private LocalDate birthDate;

	@JsonProperty
	@NotBlank(groups = { CreateValidation.class, UpdateValidation.class }, message = "name must not be blank")
	private String name;

	@JsonProperty
	@NotBlank(groups = { CreateValidation.class, UpdateValidation.class }, message = "surname must not be blank")
	private String surname;

	@JsonProperty
	@NotBlank(groups = { CreateValidation.class, UpdateValidation.class }, message = "email must not be blank")
	private String email;

	@JsonProperty
	@NotBlank(groups = { CreateValidation.class, UpdateValidation.class }, message = "phoneNumber must not be blank")
	private String phoneNumber;
	
	public interface CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation {
		// validation group marker interface
	}

}