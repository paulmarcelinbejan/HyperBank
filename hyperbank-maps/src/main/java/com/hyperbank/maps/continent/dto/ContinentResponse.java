package com.hyperbank.maps.continent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ContinentResponse {

	@JsonProperty
	private Integer id;

	@JsonProperty
	private String continentName;

}
