package com.hyperbank.accounts.customerlegalentity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerLegalEntitySaveRequest {

	@JsonProperty
	@NotNull(message = "headquartersId must not be null")
	private Long headquartersId;

	@JsonProperty
	@NotBlank(message = "name must not be blank")
	private String name;
	
}