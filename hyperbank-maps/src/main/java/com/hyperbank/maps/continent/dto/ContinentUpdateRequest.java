package com.hyperbank.maps.continent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ContinentUpdateRequest {

	@JsonProperty
	@NotNull(message = "id must not be null")
	private Integer id;

	@JsonProperty
	@NotBlank(message = "continentName must not be blank")
	private String continentName;

}
