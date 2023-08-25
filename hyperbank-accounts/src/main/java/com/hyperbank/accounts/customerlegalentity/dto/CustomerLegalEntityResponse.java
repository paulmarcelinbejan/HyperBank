package com.hyperbank.accounts.customerlegalentity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerLegalEntityResponse {

	@JsonProperty
	private Long id;

	@JsonProperty
	private Long fkHeadquarters;

	@JsonProperty
	private String name;
	
}