package com.hyperbank.maps.country.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CountryUpdateRequest {

	@JsonProperty
	@NotNull(message = "id must not be null")
	private Integer id;

	@JsonProperty
	@NotNull(message = "continentId must not be null")
	private Integer continentId;

	@JsonProperty
	@NotBlank(message = "countryName must not be blank")
	private String countryName;

}
