package com.hyperbank.maps.country.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CountryResponse {

	@JsonProperty
	private Integer id;

	@JsonProperty
	private Integer continentId;

	@JsonProperty
	private String countryName;

}
