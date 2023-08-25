package com.hyperbank.maps.location.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LocationResponse {

	@JsonProperty
	private Long id;

	@JsonProperty
	private Integer cityId;

	@JsonProperty
	private String streetName;

	@JsonProperty
	private Integer streetNumber;

	@JsonProperty
	private String postalCode;

}
