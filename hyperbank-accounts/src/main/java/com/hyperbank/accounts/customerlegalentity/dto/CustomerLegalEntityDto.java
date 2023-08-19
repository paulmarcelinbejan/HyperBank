package com.hyperbank.accounts.customerlegalentity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CustomerLegalEntityDto {

	@JsonProperty
	@Null(groups = { CreateValidation.class }, message = "id must be null")
	@NotNull(groups = { UpdateValidation.class }, message = "id must not be null")
	private Long id;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "fkHeadquarters must not be null")
	private Long fkHeadquarters;

	@JsonProperty
	@NotBlank(groups = { CreateValidation.class, UpdateValidation.class }, message = "name must not be blank")
	private String name;

	public interface CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation {
		// validation group marker interface
	}
	
}