package com.hyperbank.interests.interestratefixed.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InterestRateFixedResponse {

	@JsonProperty
	private Long id;
	
	@JsonProperty
	private BigDecimal percentage;
	
}