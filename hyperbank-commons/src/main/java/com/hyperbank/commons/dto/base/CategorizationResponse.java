package com.hyperbank.commons.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public abstract class CategorizationResponse {

	@JsonProperty
	private Integer id;

	@JsonProperty
	private String code;

	@JsonProperty
	private String description;
	
}
