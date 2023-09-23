package com.hyperbank.interests.interestratevariable.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InterestRateVariableSaveRequest {

	@JsonProperty
	@NotBlank(message = "code must not be blank")
	private String name;
	
}