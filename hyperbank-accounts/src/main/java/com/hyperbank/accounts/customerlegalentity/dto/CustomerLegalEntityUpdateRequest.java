package com.hyperbank.accounts.customerlegalentity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerLegalEntityUpdateRequest {

	@JsonProperty
	@NotNull(message = "id must not be null")
	private Long id;

	@JsonProperty
	@NotNull(message = "fkHeadquarters must not be null")
	private Long fkHeadquarters;

	@JsonProperty
	@NotBlank(message = "name must not be blank")
	private String name;
	
}