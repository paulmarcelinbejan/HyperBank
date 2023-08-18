package com.hyperbank.accounts.customerlegalentity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerLegalEntityDto {

	@JsonProperty
	private Long id;

	@JsonProperty
	private Long fkHeadquarters;

	@JsonProperty
	private String name;

	public interface CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation {
		// validation group marker interface
	}
	
}