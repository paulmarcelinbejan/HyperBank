package com.hyperbank.maps.city.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CityUpdateRequest {

	@JsonProperty
	@NotNull(message = "id must not be null")
	private Integer id;

	@JsonProperty
	@NotNull(message = "countryId must not be null")
	private Integer countryId;

	@JsonProperty
	@NotBlank(message = "cityName must not be blank")
	private String cityName;

}
