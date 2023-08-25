package com.hyperbank.maps.location.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LocationUpdateRequest {

	@JsonProperty
	@NotNull(message = "id must not be null")
	private Long id;

	@JsonProperty
	@NotNull(message = "cityId must not be null")
	private Integer cityId;

	@JsonProperty
	@NotBlank(message = "streetName must not be blank")
	private String streetName;

	@JsonProperty
	@NotNull(message = "streetNumber must not be null")
	@Positive(message = "streetNumber must be positive")
	private Integer streetNumber;

	@JsonProperty
	@NotBlank(message = "postalCode must not be blank")
	private String postalCode;
	
}
