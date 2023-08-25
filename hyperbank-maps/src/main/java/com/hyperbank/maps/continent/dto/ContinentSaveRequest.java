package com.hyperbank.maps.continent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContinentSaveRequest {

	@JsonProperty
	@NotBlank(message = "continentName must not be blank")
	private String continentName;

}
