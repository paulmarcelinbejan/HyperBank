package com.hyperbank.maps.city.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CityResponse {

	@JsonProperty
	private Integer id;

	@JsonProperty
	private Integer countryId;

	@JsonProperty
	private String cityName;

}
