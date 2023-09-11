package com.hyperbank.interests.interestratefixed.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class InterestRateFixedSaveRequest {
	
	@JsonProperty
	private BigDecimal percentage;
	
}