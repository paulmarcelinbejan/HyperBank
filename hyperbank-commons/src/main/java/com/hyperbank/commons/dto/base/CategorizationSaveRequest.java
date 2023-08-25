package com.hyperbank.commons.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public abstract class CategorizationSaveRequest {

	@JsonProperty
	@NotBlank(message = "code must not be blank")
	private String code;

	@JsonProperty
	@NotBlank(message = "description must not be blank")
	private String description;
	
}
