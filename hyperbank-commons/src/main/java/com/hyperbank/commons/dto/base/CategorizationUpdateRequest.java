package com.hyperbank.commons.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public abstract class CategorizationUpdateRequest {

	@JsonProperty
	@NotNull(message = "id must not be null")
	private Integer id;

	@JsonProperty
	@NotBlank(message = "code must not be blank")
	private String code;

	@JsonProperty
	@NotBlank(message = "description must not be blank")
	private String description;
	
}
